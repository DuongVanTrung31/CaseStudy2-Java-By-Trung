package _Service_Manager;

import _Crawls_Data._List_Data_TGDĐ.ListProduct;
import _IO_File.IOFileBinary;

import _Model_Product.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductManager implements IManager<Product>{
    private ArrayList<Product> productArrayList;
    private IOFileBinary<Product> ioFileBinaryProduct = new IOFileBinary<>();
    private final String PATH_OF_PRODUCT = "FileData/product";

    public ProductManager() {
        if(new File(PATH_OF_PRODUCT).length() == 0) {
            productArrayList = new ArrayList<>();
        } else {
            productArrayList = ioFileBinaryProduct.readFileData(PATH_OF_PRODUCT);
        }
    }

    public void setDataCrawls() {
        ListProduct listProduct = new ListProduct();
        productArrayList.addAll(listProduct.setListLaptop());
        productArrayList.addAll(listProduct.setListTablet());
        productArrayList.addAll(listProduct.setListSmartphone());
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    @Override
    public void display() {
        productArrayList = ioFileBinaryProduct.readFileData(PATH_OF_PRODUCT);
        if(productArrayList.isEmpty()){
            System.out.println("\t\tChưa có sản phẩm nào");
        } else {
            productArrayList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        productArrayList.removeIf(p -> p.getId() == id);
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    @Override
    public void deleteAll() {
        productArrayList.clear();
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    @Override
    public void add(Product product) {
        productArrayList.add(product);
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    @Override
    public void editName(int id, String editName) {
        for (Product p: productArrayList) {
            if(p.getId() == id) {
                p.setName(editName);
            }
        }
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    @Override
    public void editPrice(int id, double price) {
        for (Product p: productArrayList) {
            if(p.getId() == id) {
                p.setPrice(price);
            }
        }
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Product p: productArrayList) {
            if(p.getId() == id) {
                p.setBrand(brand);
            }
        }
        ioFileBinaryProduct.writerFileData(productArrayList,PATH_OF_PRODUCT);
    }


    public ArrayList<Product> findProductByBrand(String keyword){
        ArrayList<Product> listBySearch = new ArrayList<>();
        for (Product p: productArrayList) {
            if(checkKey(keyword,p.getBrand())|| checkKey(keyword,p.getName())) {
                listBySearch.add(p);
            }
        }
        return listBySearch;
    }


    private boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public ArrayList<Product> productSearchByPrice(double lowPrice, double highPrice) {
        Iterator<Product> iterator = productArrayList.iterator();
        ArrayList<Product> listBySearch = new ArrayList<>();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getPrice() > lowPrice && p.getPrice() < highPrice) {
                listBySearch.add(p);
            }
        }
        return listBySearch;
    }
}
