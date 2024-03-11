public class Amazon {
    private DeliveryService service;

    static{
        System.out.println("Amazon class is loaded.");
    }

    Amazon(){
        System.out.println("Amazon bean is created.");
    }

    Amazon(DeliveryService service){
        System.out.println("Injection through Constructor.");
        this.service = service;
    }

    public void setService(DeliveryService service){
        System.out.println("Injection through Setter.");
        this.service = service;
    }

    public Boolean deliverTheProduct(Double amount){
        return service.deliverProduct(amount);
    }
}
