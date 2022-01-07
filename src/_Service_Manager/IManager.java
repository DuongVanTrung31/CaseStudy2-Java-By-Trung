package _Service_Manager;

public interface IManager<E> {
    void display();
    void delete(int id);
    void deleteAll();
    void add(E e);
    void editName(int id,String editName);
    void editPrice(int id,double price);
    void editBrand(int id,String brand);
}
