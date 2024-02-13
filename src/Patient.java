public class Patient {
    private static int counter = 0;
    private final int id;
    private String surname;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private final int cardNumber;
    private String diagnosis;

    public Patient(String surname, String name, String lastName, String address, String phoneNumber, int cardNumber, String diagnosis) {
        counter++;
        this.id = counter;
        setSurname(surname);
        setName(name);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        this.cardNumber = cardNumber;
        setDiagnosis(diagnosis);
    }

    public Patient[] getPatientsByDiagnosis(Patient[] patients, String diagnosis) {
        int requiredPatientsCount = 0;
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals(diagnosis)) {
                requiredPatientsCount++;
            }
        }
        Patient[] result = new Patient[requiredPatientsCount];
        for (int i = 0, j = 0; i < patients.length; i++) {
            if (patients[i].getDiagnosis().equals(diagnosis)) {
                result[j] = patients[i];
                j++;
            }
        }
        return result;
    }

    public Patient[] getPatientsFromCardNumberRange(Patient[] patients, int cardNumberFrom, int cardNumberTo) {
        int requiredPatientsCount = 0;
        for (Patient patient : patients) {
            if (patient.getCardNumber() >= cardNumberFrom && patient.getCardNumber() <= cardNumberTo) {
                requiredPatientsCount++;
            }
        }
        Patient[] result = new Patient[requiredPatientsCount];
        int j = 0;
        for (Patient patient : patients) {
            if (patient.getCardNumber() >= cardNumberFrom && patient.getCardNumber() <= cardNumberTo) {
                result[j] = patient;
                j++;
            }
        }
        return result;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String toString() {
        return "ID " + getId() + "\n" + "Фамилия " + getSurname() + "\n" + "Имя" + getName() + "\n" + "Отчество " +
                getLastName() + "\n" + "Адрес " + getAddress() + "\n" + "Номер телефона " + getPhoneNumber() + "\n" +
                "Номер карты " + getCardNumber() + "\n" + "Диагноз " + getDiagnosis() + "\n";
    }

    public static void exampleForUsage() {
        Patient[] patients = new Patient[10];
        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient("surname" + i, "name" + i, "lastName" + i, "address" + i, "phoneNumber" + i, i, "diagnosis" + i);
        }

        String diagnosis = "diagnosis0";
        Patient[] patientsByDiagnosis = patients[0].getPatientsByDiagnosis(patients, diagnosis);
        System.out.println("!!! Пациенты с диагнозом " + diagnosis);
        for (Patient patient : patientsByDiagnosis) {
            System.out.println(patient.toString() + "\n_____________________________\n");
        }

        int[] cardNumberRange = {0, 10};
        Patient[] patientsFromCardNumberRange = patients[0].getPatientsFromCardNumberRange(patients,  cardNumberRange[0], cardNumberRange[1]);
        System.out.println("!!! Пациенты с номером карты от " + cardNumberRange[0] + " до " + cardNumberRange[1]);
        for (Patient patient : patientsFromCardNumberRange) {
            System.out.println(patient.toString() + "\n_____________________________\n");
        }
    }
}
