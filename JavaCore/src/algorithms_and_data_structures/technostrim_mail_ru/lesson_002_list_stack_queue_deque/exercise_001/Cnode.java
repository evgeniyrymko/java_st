package algorithms_and_data_structures.technostrim_mail_ru.lesson_002_list_stack_queue_deque.exercise_001;

// Элемент двусвязного списка с целочисленными данными
public class Cnode {
    int data;
    Cnode next;
    Cnode previous;

    public Cnode() {
        this.data = 0;
        this.next = null;
        this.previous = null;
    }

    public Cnode(int data, Cnode next, Cnode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    // Линейный поиск элемента a в списке; возвращает null, если элемент не найден
    Cnode search(Cnode head, int a) {
        Cnode current = head;
        while (current != null) {
            if (current.data == a) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Вставка элемента a после текущего элемента
    Cnode insertAfter(Cnode node, int a) {
        if (node != null) {
            // Создаем новый элемент
            Cnode newNode = new Cnode();
            newNode.data = a;
            newNode.previous = node;
            newNode.next = node.next;
            // Обновляем previous следующего элемента, если он есть
            if (node.next != null) {
                node.next.previous = newNode;
            }
            // Обновляем next текущего элемента node
            node.next = newNode;
            return newNode;
        }
        return null;
    }
    // Удаление элемента делается аналогично, особенность заключается лишь в расстановке "связок"
    // Объединение односвязных списков. К списку 1 добавляем список 2. Возвращает указатель на начало нового списка
    Cnode union(Cnode head1, Cnode head2){
        if (head1==null) {
            return head2;
        }
        if (head2==null) {
            return head1;
        }
        // Идем в хвост списка 1 и обновляем next хвоста
        Cnode tail1=head1;
        while (tail1.next!=null) {
            tail1=tail1.next;
        }
        tail1.next=head2;
        return head1;
    }
}
