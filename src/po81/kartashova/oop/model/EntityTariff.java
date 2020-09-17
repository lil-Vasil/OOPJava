package po81.kartashova.oop.model;

public class EntityTariff implements Tariff {

    private Node head;
    private Node tail;
    private int size;

    public EntityTariff(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }

    public EntityTariff(int size, Service[] services) { //создание списка и заполнение его элементов
        this.size = size;
        for (Service service : services) {
            addService(service);
        }
    }

    private Node getNode(int index) { //получаем узлы списка
        Node node = head;
        if (checkIndex(index)) {
            for (int i = -1; i < index; i++) { //уточнить i=-1 и <= index
                node = node.next;
            }
        }
        return node;
    }

    private void addTo(int index, Service object) { //метод добавления объекта по индексу
        Node nextNode = getNode(index);
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(object); //конструктор
        nextNode.previous = newNode;
        if (head == null) {
            head = newNode;
        } else {
            prevNode.next = newNode; //спросить на счет next (дописала сама)
        }
    }

    private boolean checkIndex(int index) { // проверяем индекс
        return (index >= 0 && index <= size);
    }

    //метод возвращающий ссылку на узел по его номеру в списке
    private Node get(int index) {
        return getNode(index); //спросить, нужно ли здесь условие и value
    }

    // метод удаляющий узел по его номеру в списке
    private boolean removeNode(int index) { //проверить!
        if (checkIndex(index)) {
            getNode(index).setNext(getNode(index + 1));
            return true;
        }
        return false;
    }

    @Override
    public boolean addService(Service service) {
        Node lastNode = getNode(size - 1);
        lastNode.next = new Node(service);
        size++;
        return true;
    }

    @Override
    public boolean addServicesByNumber(int index, Service object) { //метод, добавляющий узел в заданную позицию в списке
        if (checkIndex(index)) { //почему подчеркивает?
            if (index == size) {
                addService(object);
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

    @Override
    public Service getService(int index) {
        Node newService = head;
        if (checkIndex(index)) {
            for (int i = 0; i <= index; i++) {
                newService = newService.next;
            }
        }
        return newService.object;
    }

    @Override
    public Service getLinkByName(String name) { //Todo
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return getNode(i).object;
            }
        }
        return null;
    }

    @Override
    public boolean getServiceByName(String name) { //Todo
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Service changeLinkByIndex(int index, Service service) { // метод, меняющий узел с заданным номером
        if (checkIndex(index)) {
            Service newService = getNode(index).object;
            getNode(index).object = service;
            return newService;
        }
        return null;
    }

    @Override
    public Service deleteServiceByIndex(int index) {
        if (checkIndex(index)) {
            Service myNode = getNode(index).object;
            removeNode(index);
            return myNode;
        }
        return null;

    }

    @Override
    public Service deleteServiceByName(String name) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                removeNode(i);
            }
        }
        return null;
    }

    @Override
    public int getCountOfServices() {
        return size;
    }

    @Override
    public Service[] serviceNotNullArray() {
        Service[] services = new Service[size];
        for (int i = 0; i < size; i++) {
            services[i] = getNode(i).object;
        }
        return services;
    }

    @Override
    public Service[] servicesSortArray() { //Todo
        Service[] services = serviceNotNullArray(); //почему подчеркивает
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < services.length - 1; i++) {
                if (services[i].getPrice() > services[i + 1].getPrice()) {
                    Service tmp = services[i + 1];
                    services[i + 1] = services[i];
                    services[i] = tmp;
                    isSorted = false;
                }
            }
        }
        return services;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (int i = 0; i < size; i++) {
            price += getNode(i).object.getPrice();
        }
        return price;
    }

    public class Node {

        Service object;
        Node next;
        Node previous;

        public Node(Node next, Node previous) {
            this.next = next;
            this.previous = previous;
        }

        public Node(Service object) {
            this.object = object;
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
    }
}
