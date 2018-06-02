class Patient {
    private String name;
    private int age;
    private boolean ill;
    private String diagnosis;

    public Patient(String name, int age, boolean ill, String diagnosis) {
        this.name = name;
        this.age = age;
        this.ill = ill;
        this.diagnosis = diagnosis;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        String str = "\nPatient " + name + " - Age = " + age;
        if (ill)
            str = str.concat(" Current status: ill, Diagnosis: " + diagnosis);
        else
            str = str.concat(" Current status: healthy");
        return str;
    }
}
