package po81.kartashova.oop.model.tariff;

import po81.kartashova.oop.model.Service;

public class EntityTariff extends AbstractTariff {

    private Node head;
    private Node tail;
    private int size;

    public EntityTariff() {
        this.head = null;
        this.tail = null;
    }

    public EntityTariff(int size, Service[] services) {
        this.size = size;
        for (Service service : services) {
            addService(service);
        }
    }

    private Node getNode(int index) {
        Node node = head;
        if (checkIndex(index)) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    private boolean checkIndex(int index) { // проверяем индекс
        return (index >= 0 && index <= size);
    }

    private Node get(int index) {
        return getNode(index);
    }


    private boolean removeNode(int index) {
        if (checkIndex(index)) {
            Node previous = getNode(index - 1);
            Node next = getNode(index + 1);
            Node deleteNode = getNode(index);
            deleteNode.previous = null;
            deleteNode.next = null;
            previous.next = next;
            next.previous = previous;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addService(Service service) {
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

    @Override
    public boolean addServicesByNumber(int index, Service object) {
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


    private void addTo(int index, Service object) {
        Node nextNode = getNode(index);
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(object);
        nextNode.previous = newNode;
        if (head == null) {
            head = newNode;
        } else {
            prevNode = newNode;
        }
    }

    @Override
    public Service getService(int index) {
        Node newService = head;
        if (checkIndex(index)) {
            for (int i = 0; i < index; i++) {
                newService = newService.next;
            }
        }
        return newService.object;
    }

    @Override
    public Service getLinkByName(String name) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return getNode(i).object;
            }
        }
        return null;
    }

    @Override
    public boolean getServiceByName(String name) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).object.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Service changeLinkByIndex(int index, Service service) {
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
                Service deletedService = getNode(i).object;
                removeNode(i);
                return deletedService;
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

        public Node(Service object, Node previous, Node next) {
            this.object = object;
            this.next = next;
            this.previous = previous;
        }
    }
}
