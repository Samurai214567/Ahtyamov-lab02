#include <iostream>
using namespace std;

// Структура узла однонаправленного списка
struct Node {
    int data;       // Данные узла
    Node* next;     // Указатель на следующий узел
    
    // Конструктор для удобного создания узлов
    Node(int value) : data(value), next(nullptr) {}
};

class LinkedList {
private:
    Node* head;     // Указатель на первый узел списка

public:
    // Конструктор - инициализируем пустой список
    LinkedList() : head(nullptr) {}
    
    // Добавление элемента в конец списка
    void append(int data) {
        // Создаем новый узел
        Node* newNode = new Node(data);
        
        // Если список пустой - новый узел становится головой
        if (head == nullptr) {
            head = newNode;
            return;
        }
        
        // Идем до последнего узла в списке
        Node* current = head;
        while (current->next != nullptr) {
            current = current->next;
        }
        
        // Присоединяем новый узел к концу списка
        current->next = newNode;
    }
    
    // Вывод списка на экран
    void display() {
        if (head == nullptr) {
            cout << "Список пуст!" << endl;
            return;
        }
        
        Node* current = head;
        cout << "Список: ";
        while (current != nullptr) {
            cout << current->data << " -> ";
            current = current->next;
        }
        cout << "NULL" << endl;
    }
    
    // Деструктор - освобождаем память
    ~LinkedList() {
        Node* current = head;
        while (current != nullptr) {
            Node* next = current->next;
            delete current;
            current = next;
        }
    }
};

// Пример использования
int main() {
    LinkedList list;
    
    // Добавляем элементы в список
    list.append(10);
    list.append(20);
    list.append(30);
    
    // Выводим список
    list.display();
    
    return 0;
}
