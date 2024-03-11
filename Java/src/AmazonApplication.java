public class AmazonApplication {

    private DeliveryService service;

    public AmazonApplication(DeliveryService service){
        this.service = service;
    }
    /*
    public void setService(DeliveryService service) {
        this.service = service;
    }
    */

    public Boolean deliverTheProduct(Double amount){
        // FedEx fd = new FedEx();
        return service.deliveryProduct(amount);
    }
}
