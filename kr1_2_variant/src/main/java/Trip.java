public class Trip {

    private Long clientCall;
    private String clientName;
    private String avtoNumber;
    private Long voditelNumber;
    private String voditelName;
    private String addressOtpr;
    private String addressPrib;
    private TripDate dateOtpr;
    private TripDate datePrib;

    public void setAvtoNumber(String avtoNumber) {
        this.avtoNumber = avtoNumber;
    }

    public long getClientCall() {
        return clientCall;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAvtoNumber() {
        return avtoNumber;
    }

    public long getVoditelNumber() {
        return voditelNumber;
    }

    public String getVoditelName() {
        return voditelName;
    }

    public String getAddressOtpr() {
        return addressOtpr;
    }

    public String getAddressPrib() {
        return addressPrib;
    }

    public TripDate getDateOtpr() {
        return dateOtpr;
    }

    public TripDate getDatePrib() {
        return datePrib;
    }
    public Trip(String date) {
        String[] newDate = date.split(";");
        this.clientCall = Long.parseLong(newDate[0]);
        this.clientName = newDate[1];
        this.avtoNumber = newDate[2];
        this.voditelNumber = Long.parseLong(newDate[3]);
        this.voditelName = newDate[4];
        this.addressOtpr = newDate[5];
        this.addressPrib = newDate[6];
        this.dateOtpr = new TripDate(newDate[7]);
        this.datePrib = new TripDate(newDate[8]);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "номер клиента : " + clientCall +
                ", имя клиента : '" + clientName + '\'' +
                ", номер машины : '" + avtoNumber + '\'' +
                ", номер водителя : " + voditelNumber +
                ", имя водителя : " + voditelName + '\'' +
                ", адрес отправления : " + addressOtpr + '\'' +
                ", адрес прибытия : " + addressPrib + '\'' +
                ", дата отправления : " + dateOtpr +
                ", дата прибытия : " + datePrib +
                '}';
    }
}
