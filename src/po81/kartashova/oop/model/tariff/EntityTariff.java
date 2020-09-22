package po81.kartashova.oop.model.tariff;

import po81.kartashova.oop.model.Service;

public class EntityTariff extends AbstractTariff {

    private Node head;
    private Node tail;
    private int size;

    public EntityTariff() { //конструктор, в который мы ничего не передаем
        this.head = null;
        this.tail = null;
    }

    public EntityTariff(int size, Service[] services) { //создание списка и заполнение его элементов
        this.size = size;
        for (Service service : services) {
            addService(service);
        }
    }

    //todo
    private Node getNode(int index) { //получаем узлы списка
        Node node = head;
        if (checkIndex(index)) {
            for (int i = 0; i < index; i++) { //уточнить i=-1 и <= index
                node = node.next;
            }
        }
        return node;
    }

    private boolean checkIndex(int index) { // проверяем индекс
        return (index >= 0 && index <= size);
    }

    //метод возвращающий ссылку на узел по его номеру в списке

    private Node get(int index) {
        return getNode(index); //спросить, нужно ли здесь условие и value
    }

    //Todo проверить правильность работы метода
    private boolean removeNode(int index) {  // метод удаляющий узел по его номеру в списке
        if (checkIndex(index)) {
            Node previous = getNode(index - 1);
            Node next = getNode(index + 1);
            Node deleteNode = getNode(index);
            deleteNode.previous = null;
            deleteNode.next = null;
            previous.next = next;
            next.previous = previous;
//            getNode(index-1).next = getNode(index + 1);
//            getNode(index+1).previous = getNode(index-1);
            return true;
        }
        return false;
    }

    @Override
    public boolean addService(Service service) { //done
        Node last = tail;
        Node newNode = new Node(service, last, null);
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        return true;
    }

    @Override //Todo условие size++. Не работает замена
    public boolean addServicesByNumber(int index, Service object) { //метод, добавляющий узел в заданную позицию в списке
        if (checkIndex(index)) {
            if (index == size) {
                addService(object);
            } else {
                addTo(index, object);
            }
            return true;
        }
        return false;
    }

    //Todo работает, но не работает метод addServiceByIndex
    private void addTo(int index, Service object) { //метод добавления объекта по индексу
        Node nextNode = getNode(index);
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(object); //конструктор
        nextNode.previous = newNode;
        if (head == null) {
            head = newNode;
        } else {
            prevNode = newNode; //спросить на счет next (дописала сама)
        }
    }

    @Override
    public Service getService(int index) { //done
        Node newService = head;
        if (checkIndex(index)) {
            for (int i = 0; i < index; i++) {
                newService = newService.next;
            }
        }
        return newService.object;
    }

    @Override
    public Service getLinkByName(String name) { //done
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return getNode(i).object;
            }
        }
        return null;
    }

    @Override
    public boolean getServiceByName(String name) { //done
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Service changeLinkByIndex(int index, Service service) { //done
        if (checkIndex(index)) {
            Service newService = getNode(index).object;
            getNode(index).object = service;
            return newService;
        }
        return null;
    }

    @Override //Todo
    public Service deleteServiceByIndex(int index) {
        if (checkIndex(index)) {
            Service myNode = getNode(index).object;
            removeNode(index);
            return myNode;
        }
        return null;
    }

    @Override //Todo ? опять под вопросом метод removeNode
    public Service deleteServiceByName(String name) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                removeNode(i);
            }
        }
        return null;
    }

    @Override
    public int getCountOfServices() { //done
        return size;
    }

    @Override
    public Service[] serviceNotNullArray() { //done
        Service[] services = new Service[size];
        for (int i = 0; i < size; i++) {
            services[i] = getNode(i).object;
        }
        return services;
    }


    @Override
    public int getPrice() {  //done
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

        public Node(Service object, Node previous, Node next) {
            this.object = object;
            this.next = next;
            this.previous = previous;
        }
    }
}
