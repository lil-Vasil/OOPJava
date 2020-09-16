package po81.kartashova.oop.model;

public class EntityTariff {

    private Node head;
    private Node tail;
    private int size;

    public EntityTariff(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }

    public EntityTariff(int size, Tariff[] objects) { //создание списка и заполнение его элементов
        this.size = size;
        for (Tariff object : objects) {
            addObjectAtLast(object);
        }
    }

    private Node getNode(int index) { //получаем узлы списка
        Node node = head;
        if (checkIndex(index)) {
            for (int i = -1; i <= index; i++) { //уточнить i=-1 и <= index
                node = node.next;
            }
        }
        return node;
    }

    public boolean addObjectAtLast(Tariff object) { //добавляем узел в конец списка
        Node lastNode = getNode(size - 1);
        lastNode.next = new Node(object);
        size++;
        return true;
    }

    //Todo метод, добавляющий узел в заданную позицию в списке
    public boolean addObjectByIndex(int index, Tariff object) {
        if (checkIndex(index)) {
            if (index == size) {
                addObjectAtLast(object);
                size++;
                return true;
            } else {
                addTo(index, object);
                size++;
                return true;
            }
        }
        return false;
    }

    private void addTo(int index, Tariff object) { //метод добавления объекта по индексу
        Node nextNode = getNode(index);
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(object); //конструктор
        nextNode.previous = newNode;
        if (head.value == null) {
            head = newNode;
        } else {
            prevNode.next = newNode; //спросить на счет next
        }
    }

    private boolean checkIndex(int index) { // проверяем индекс
        return (index >= 0 && index <= size);
    }

    //Todo метод возвращающий ссылку на узел по его номеру в списке
    public Tariff get(int index) {
        return getNode(index); //спросить, нужно ли здесь условие и value
    }

    //Todo метод удаляющий узел по его номеру в списке
    public boolean removeNode(int index) { //что вообще я здесь делаю
        if (checkIndex(index)) {
            getNode(index).setNext(getNode(index + 1));
            return true;
        }
        return false;
    }


    public class Node implements Tariff {

        Object value;
        Node node;
        Tariff object;
        Node next;
        Node previous;

        public Node(Node node) {
            this.node = node;
        }

        public Node(Object value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(Tariff object) {
            this.object = object;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public boolean addService(Service service) {
            return false;
        }

        @Override
        public boolean addServicesByNumber(int index, Service service) {
            return false;
        }

        @Override
        public Service getService(int countOfService) {
            return null;
        }

        @Override
        public Service getLinkByName(String name) {
            return null;
        }

        @Override
        public boolean getServiceByName(String name) {
            return false;
        }

        @Override
        public Service changeLinkByIndex(int index, Service service) {
            return null;
        }

        @Override
        public Service deleteServiceByIndex(int index) {
            return null;
        }

        @Override
        public Service deleteServiceByName(String name) {
            return null;
        }

        @Override
        public int getCountOfServices() {
            return 0;
        }

        @Override
        public Service[] serviceNotNullArray() {
            return new Service[0];
        }

        @Override
        public Service[] servicesSortArray() {
            return new Service[0];
        }

        @Override
        public int getPrice() {
            return 0;
        }
    }
}
