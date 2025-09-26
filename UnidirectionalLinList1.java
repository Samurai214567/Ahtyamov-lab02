// Класс узла однонаправленного списка
class Node {
    int data;        // Данные узла
    Node next;       // Ссылка на следующий узел
    
    // Конструктор узла
    public Node(int data) {
        this.data = data;
        this.next = null;  // По умолчанию следующий узел отсутствует
    }
}

// Класс однонаправленного связного списка
class LinkedList {
    private Node head;  // Ссылка на первый узел списка
    
    // Конструктор списка
    public LinkedList() {
        this.head = null;  // Изначально список пустой
    }
    
    // Добавление элемента в конец списка
    public void append(int data) {
        // Создаем новый узел
        Node newNode = new Node(data);
        
        // Если список пустой, новый узел становится головой
        if (head == null) {
            head = newNode;
            return;
        }
        
        // Ищем последний узел в списке
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Добавляем новый узел в конец
        current.next = newNode;
    }
    
    // Вывод списка на экран
    public void display() {
        if (head == null) {
            System.out.println("Список пуст!");
            return;
        }
        
        Node current = head;
        System.out.print("Список: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    // Получение размера списка
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Демонстрация работы
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Добавляем элементы в список
        list.append(5);
        list.append(10);
        list.append(15);
        
        // Выводим список
        list.display();
        
        // Показываем размер
        System.out.println("Размер списка: " + list.size());
    }
}
