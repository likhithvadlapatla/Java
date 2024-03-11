public class Amazon {
    private DeliveryService service;

    static{
        System.out.println("Amazon class is loaded.");
    }

    Amazon(){
        System.out.println("Amazon bean is created.");
    }

    Amazon(DeliveryService service){
        this.service = service;
    }

    public void setService(DeliveryService service){
        this.service = service;
    }

    public Boolean deliverTheProduct(Double amount){
        return service.deliverProduct(amount);
    }
}
