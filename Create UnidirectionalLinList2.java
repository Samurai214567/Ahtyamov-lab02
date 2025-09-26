class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class AdvancedLinkedList {
    private Node head;
    
    public AdvancedLinkedList() {
        this.head = null;
    }
    
    // Добавление в начало списка
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;  // Новый узел ссылается на текущую голову
        head = newNode;       // Новый узел становится новой головой
    }
    
    // Удаление элемента по значению
    public boolean remove(int value) {
        // Если список пустой
        if (head == null) return false;
        
        // Если удаляем головной узел
        if (head.data == value) {
            head = head.next;  // Перемещаем голову на следующий узел
            return true;
        }
        
        // Ищем узел, предшествующий удаляемому
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        
        // Если нашли узел для удаления
        if (current.next != null) {
            current.next = current.next.next;  // "Перескакиваем" через удаляемый узел
            return true;
        }
        
        return false;  // Элемент не найден
    }
    
    // Поиск элемента в списке
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Получение элемента по индексу
    public Integer get(int index) {
        // Проверка корректности индекса
        if (index < 0) return null;
        
        Node current = head;
        int currentIndex = 0;
        
        // Двигаемся до нужного индекса
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        
        // Если индекс существует, возвращаем данные
        return (current != null) ? current.data : null;
    }
    
    // Реверс списка (разворот)
    public void reverse() {
        Node previous = null;   // Предыдущий узел
        Node current = head;    // Текущий узел
        Node next = null;       // Следующий узел
        
        while (current != null) {
            next = current.next;      // Запоминаем следующий узел
            current.next = previous;  // Разворачиваем ссылку
            previous = current;       // Сдвигаем предыдущий
            current = next;           // Сдвигаем текущий
        }
        
        head = previous;  // Новая голова - бывший последний узел
    }
    
    public void display() {
        Node current = head;
        System.out.print("Список: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}

public class AdvancedExample {
    public static void main(String[] args) {
        AdvancedLinkedList list = new AdvancedLinkedList();
        
        // Добавляем элементы
        list.prepend(30);
        list.prepend(20);
        list.prepend(10);
        
        System.out.println("Исходный список:");
        list.display();
        
        // Поиск элементов
        System.out.println("Содержит 20: " + list.contains(20));
        System.out.println("Содержит 50: " + list.contains(50));
        
        // Получение элемента по индексу
        System.out.println("Элемент с индексом 1: " + list.get(1));
        
        // Разворот списка
        System.out.println("После разворота:");
        list.reverse();
        list.display();
        
        // Удаление элемента
        list.remove(20);
        System.out.println("После удаления 20:");
        list.display();
    }
}
