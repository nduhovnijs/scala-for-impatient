// Scala vs Java lines of code : 19 vs 65 
//
// haven-macbook:Chapter05 nduhovnijs$ grep -v '//' Ch05Ex08.scala | wc -l
//      19
// haven-macbook:Chapter05 nduhovnijs$ grep -v '//' Ch05Ex09.java | wc -l
//      65
//
// Ok, I'm definitely not a Java dev, so maybe some compaction is possible.
// Still, quite impressive difference.
class Car {
    private String manufacturer;
    private String modelName;
    private Integer modelYear;
    private String licensePlate;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlateArg) {
        licensePlate = licensePlateArg;
    }
    
    // Java appeared not supporting default parameters
    public Car(String manufacturer, String modelName, Integer modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear; 
        this.licensePlate = licensePlate;
    }

    public Car(String manufacturer, String modelName) {
        this(manufacturer, modelName, -1, "");
    }

    public Car(String manufacturer, String modelName, Integer modelYear) {
        this(manufacturer, modelName, modelYear, "");
    }

    public Car(String manufacturer, String modelName, String licensePlate) {
        this(manufacturer, modelName, -1, licensePlate);
    }

    public String toString() {
        return manufacturer + " " + modelName + " " + modelYear + " " + licensePlate;
    }
}

public class Ch05Ex09 {
    public static void main(String[] args) {
        Car corolla = new Car("Toyota", "Corolla", 1992, "AB-1992");
        System.out.println(corolla);
    
        Car prius = new Car("Toyota", "Prius");
        System.out.println(prius);

        Car aveo = new Car("Chevrolet", "Aveo", 2008);
        System.out.println(aveo);

        Car insignia = new Car("Opel", "Insignia", "AC-2012");
        System.out.println(insignia);
    }
}
