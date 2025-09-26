#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int value) : data(value), next(nullptr) {}
};

class AdvancedLinkedList {
private:
    Node* head;

public:
    AdvancedLinkedList() : head(nullptr) {}
    
    // Добавление в начало списка
    void prepend(int data) {
        Node* newNode = new Node(data);
        newNode->next = head;  // Новый узел указывает на старую голову
        head = newNode;        // Новый узел становится новой головой
    }
    
    // Удаление элемента по значению
    bool remove(int value) {
        // Если список пустой - ничего не удаляем
        if (head == nullptr) return false;
        
        // Если удаляемый элемент - голова списка
        if (head->data == value) {
            Node* temp = head;
            head = head->next;  // Голова перемещается на следующий узел
            delete temp;        // Освобождаем память старой головы
            return true;
        }
        
        // Ищем узел, предшествующий удаляемому
        Node* current = head;
        while (current->next != nullptr && current->next->data != value) {
            current = current->next;
        }
        
        // Если нашли узел для удаления
        if (current->next != nullptr) {
            Node* temp = current->next;      // Запоминаем удаляемый узел
            current->next = temp->next;      // "Перепрыгиваем" через удаляемый узел
            delete temp;                     // Освобождаем память
            return true;
        }
        
        return false;  // Элемент не найден
    }
    
    // Поиск элемента в списке
    bool contains(int value) {
        Node* current = head;
        while (current != nullptr) {
            if (current->data == value) {
                return true;  // Элемент найден
            }
            current = current->next;
        }
        return false;  // Элемент не найден
    }
    
    // Получение размера списка
    int size() {
        int count = 0;
        Node* current = head;
        while (current != nullptr) {
            count++;
            current = current->next;
        }
        return count;
    }
    
    void display() {
        Node* current = head;
        cout << "Список: ";
        while (current != nullptr) {
            cout << current->data << " -> ";
            current = current->next;
        }
        cout << "NULL" << endl;
    }
    
    ~AdvancedLinkedList() {
        Node* current = head;
        while (current != nullptr) {
            Node* next = current->next;
            delete current;
            current = next;
        }
    }
};

int main() {
    AdvancedLinkedList list;
    
    list.prepend(3);  // Добавляем в начало: 3
    list.prepend(2);  // Добавляем в начало: 2 -> 3
    list.prepend(1);  // Добавляем в начало: 1 -> 2 -> 3
    
    list.display();
    cout << "Размер списка: " << list.size() << endl;
    
    cout << "Поиск 2: " << (list.contains(2) ? "найден" : "не найден") << endl;
    cout << "Поиск 5: " << (list.contains(5) ? "найден" : "не найден") << endl;
    
    list.remove(2);  // Удаляем элемент 2
    list.display();
    
    return 0;
}
