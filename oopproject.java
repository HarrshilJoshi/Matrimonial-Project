import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

class PersonalDetails {
    String name;
    String fatherName;
    String motherName;
    String dob;
    char gender;
    int age;
    float height;
    float weight;
    String Occupation;
    private int salary;
    String Education;
    private String residence;
    String motongue;
    String Religion;
    String caste;
    private Long phone;

    public int getSalary() {
        return salary;
    }

    public String getResidence() {
        return residence;
    }

    public Long getPhone() {
        return phone;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class User {
    private String username;
    private String password;
    PersonalDetails personalDetails;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    User(String username, String password, PersonalDetails personalDetails) {
        this.username = username;
        this.password = password;
        this.personalDetails = personalDetails;
    }

    boolean checkLogin(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public static int calculateAge(LocalDate dob) {//// this is for calculating age as per yyyy-mm--dd

        LocalDate curDate = LocalDate.now();

        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void editPersonalDetails(Scanner scanner) throws IOException {
        //// updating the profile
        String tempFile = "E:\\java\\temp.csv";
        File originalFile = new File("E:\\java\\user5.csv");
        File tempOutputFile = new File(tempFile);
        System.out.println("------Which detail you want to change:------");
        System.out.println("1) Name ");
        System.out.println("2) Father's Name ");
        System.out.println("3) Mother's Name ");
        System.out.println("4) Date of Birth ");
        System.out.println("5) Gender ");
        System.out.println("6) Height ");
        System.out.println("7) Weight ");
        System.out.println("8) Occupation ");
        System.out.println("9) Salary ");
        System.out.println("10) Education ");
        System.out.println("11) Residence ");
        System.out.println("12) Mother Tongue  ");
        System.out.println("13) Religion ");
        System.out.println("14) Caste ");
        System.out.println("15) Phone Number ");
        System.out.println("16) Back to Main ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(originalFile));
                FileWriter fw = new FileWriter(tempOutputFile)) {

            String line;
            boolean found = false;

            switch (choice) {
                case 1:
                    System.out.println("Enter new name:");
                    personalDetails.name = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Enter new father's name:");
                    personalDetails.fatherName = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter new mother's name:");
                    personalDetails.motherName = scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Enter new date of birth (yyyy-mm-dd):");
                    personalDetails.dob = scanner.nextLine();
                    personalDetails.age = calculateAge(LocalDate.parse(personalDetails.dob));
                    break;
                case 5:
                    System.out.println("Enter new gender (M/F):");
                    personalDetails.gender = scanner.nextLine().charAt(0);
                    break;
                case 6:
                    System.out.println("Enter new height (in ft):");
                    personalDetails.height = scanner.nextFloat();
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Enter new weight:");
                    personalDetails.weight = scanner.nextFloat();
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Enter new occupation:");
                    personalDetails.Occupation = scanner.nextLine();

                    break;
                case 9:
                    System.out.println("Enter new salary:");
                    personalDetails.setSalary(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 10:
                    System.out.println("Enter new education:");
                    personalDetails.Education = scanner.nextLine();
                    break;
                case 11:
                    System.out.println("Enter new residence (city/District):");
                    personalDetails.setResidence(scanner.nextLine());
                    break;
                case 12:
                    System.out.println("Enter new mother tongue:");
                    personalDetails.motongue = scanner.nextLine();
                    break;
                case 13:
                    System.out.println("Enter new religion:");
                    personalDetails.Religion = scanner.nextLine();
                    break;
                case 14:
                    System.out.println("Enter new caste:");
                    personalDetails.caste = scanner.nextLine();
                    break;
                case 15:
                    System.out.println("Enter new phone number:");
                    personalDetails.setPhone(scanner.nextLong());
                    scanner.nextLine();
                    break;
                case 16:
                    return;
                default:
                    System.out.println("please put choice from 1 to 16 ");
                    editPersonalDetails(scanner);
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(this.username)) {
                    found = true;

                    switch (choice) {
                        case 1:
                            data[2] = personalDetails.name;
                            break;
                        case 2:
                            data[3] = personalDetails.fatherName;
                            break;
                        case 3:
                            data[4] = personalDetails.motherName;
                            break;
                        case 4:
                            data[5] = personalDetails.dob;
                            break;
                        case 5:
                            data[6] = String.valueOf(personalDetails.gender);
                            break;
                        case 6:
                            data[8] = String.valueOf(personalDetails.height);
                            break;
                        case 7:
                            data[9] = String.valueOf(personalDetails.weight);
                            break;
                        case 8:
                            data[10] = personalDetails.Occupation;
                            break;
                        case 9:
                            data[11] = String.valueOf(personalDetails.getSalary());
                            break;
                        case 10:
                            data[12] = personalDetails.Education;
                            break;
                        case 11:
                            data[13] = personalDetails.getResidence();
                            break;
                        case 12:
                            data[14] = personalDetails.motongue;
                            break;
                        case 13:
                            data[15] = personalDetails.Religion;
                            break;
                        case 14:
                            data[16] = personalDetails.caste;
                            break;
                        case 15:
                            data[17] = String.valueOf(personalDetails.getPhone());
                            break;
                    }

                    line = String.join(",", data);
                }
                fw.write(line + "\n");
            }

            if (!found) {
                System.out.println("<---------------User not found------------------>");
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(
                "<--------------------------------Information updated successfully------------------------------->");
    }

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Matchmaking {
    static boolean checkCompatibility(PersonalDetails person1, PersonalDetails person2, int n, int choice) {

        switch (choice) {//// matchmaking as per choice of users
            case 1:
                return Math.abs(person1.age - person2.age) < n && person1.gender != person2.gender
                        && person1.Religion.equals(person2.Religion) && person1.motongue.equals(person2.motongue);

            case 2:
                return Math.abs(person1.age - person2.age) < n && person1.gender != person2.gender
                        && person1.Religion.equals(person2.Religion);

            case 3:
                return Math.abs(person1.age - person2.age) < n && person1.gender != person2.gender
                        && person1.motongue.equals(person2.motongue);

            default:
                return false;

        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class DisplayCompatibles {
    public static void displayCompatibleUsers(User[] users, int numUsers, PersonalDetails currentUser) {
        int n;
        Scanner scanner = new Scanner(System.in);
        ///// choice for users
        System.out.println(
                "<---------------------What kind of factor you want to keep as in Your partner----------------->");
        System.out.println("   1) Age, Religion , Mother-tongue :    ");
        System.out.println("   2) Age, Religion :    ");
        System.out.println("   3) Age, Mother-tongue :    ");

        int choice;
        choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("How much age diffrence you want :-");
        n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("<-------------------- Compatible Users are as follows :---------------->\n");
        for (int i = 0; i < numUsers; i++) {
            if (Matchmaking.checkCompatibility(currentUser, users[i].personalDetails, n, choice)) {
                System.out.println("Name: " + users[i].personalDetails.name);
                System.out.println("Age: " + users[i].personalDetails.age);
                System.out.println("Occupation : " + users[i].personalDetails.Occupation);
                System.out.println("Residence: " + users[i].personalDetails.getResidence());
                System.out.println("Phone No. " + users[i].personalDetails.getPhone());
                System.out.println();
                System.out.println();
            }
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class register extends User {
    register(String username, String password, PersonalDetails personalDetails) {
        super(username, password, personalDetails);
    }

    static void registerUser(Scanner scanner, FileWriter fileWriter, User[] users, int numUsers) {
        PersonalDetails personalDetails = new PersonalDetails();
        System.out.println("<--------------------- Enter your details for registration:------------------->");

        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        for (int i = 0; i < numUsers; i++) {
            if (users[i].getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return;
            }
        }

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        System.out.println("Enter your name:");
        personalDetails.name = scanner.nextLine();

        System.out.println("Enter your father's name:");
        personalDetails.fatherName = scanner.nextLine();

        System.out.println("Enter your mother's name:");
        personalDetails.motherName = scanner.nextLine();

        System.out.println("Enter your date of birth in yyyy-mm-dd:");
        personalDetails.dob = scanner.nextLine();
        LocalDate dob = LocalDate.parse(personalDetails.dob);

        System.out.println("what is your gender (M/F):");
        personalDetails.gender = scanner.nextLine().charAt(0);

        personalDetails.age = calculateAge(dob);

        System.out.println("Enter your height( in cm  ):");
        personalDetails.height = scanner.nextFloat();

        System.out.println("Enter your weight( in kg ):");
        personalDetails.weight = scanner.nextFloat();
        scanner.nextLine();

        System.out.println("Enter your Occupation:");
        personalDetails.Occupation = scanner.nextLine();

        System.out.println("Enter yout salary:");
        int salary = scanner.nextInt();
        personalDetails.setSalary(salary);
        scanner.nextLine();

        System.out.println("Enter your Education :");
        personalDetails.Education = scanner.nextLine();

        System.out.println("Enter your residence(city/District): ");
        String residence = scanner.nextLine();
        personalDetails.setResidence(residence);

        System.out.println("Enter your Mothertongue: ");
        personalDetails.motongue = scanner.nextLine();

        System.out.println("Enter your Religion:");
        personalDetails.Religion = scanner.nextLine();

        System.out.println("Enter your Caste");
        personalDetails.caste = scanner.nextLine();

        System.out.println("Enter your phone number: ");
        Long phone = scanner.nextLong();
        personalDetails.setPhone(phone);
        scanner.nextLine();

        try {
            String userData = String.format("%s,%s,%s,%s,%s,%s,%c,%d,%d,%d,%s,%d,%s,%s,%s,%s,%s,%d\n",
                    username, password, personalDetails.name, personalDetails.fatherName,
                    personalDetails.motherName, personalDetails.dob, personalDetails.gender,
                    personalDetails.age, personalDetails.height, personalDetails.weight,
                    personalDetails.Occupation, personalDetails.getSalary(), personalDetails.Education,
                    personalDetails.getResidence(), personalDetails.motongue, personalDetails.Religion,
                    personalDetails.caste, personalDetails.getPhone());

            fileWriter.write(userData);
            fileWriter.flush();
            System.out.println("<--------------------------Successfully registered---------------------------->");
            users[numUsers] = new User(username, password, personalDetails);
        } catch (IOException e) {
            System.err.println("Error writing user data: " + e.getMessage());
        }
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Login extends register {
    Login(String username, String password, PersonalDetails personalDetails) {
        super(username, password, personalDetails);
    }

    static boolean loginUser(Scanner scanner, User[] users, int numUsers) {
        System.out.println("Enter your username:");
        String enteredUsername = scanner.nextLine();

        System.out.println("Enter your password:");
        String enteredPassword = scanner.nextLine();

        for (int i = 0; i < numUsers; i++) {
            if (users[i].getUsername().equals(enteredUsername) && users[i].getPassword().equals(enteredPassword)) {
                System.out.println("<----------------------------Successfully Logged-in----------------------------->");
                return true;
            }
        }
        return false;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class oopproject extends Login {
    oopproject(String username, String password, PersonalDetails personalDetails) {
        super(username, password, personalDetails);
    }

    static User findUserByUsername(User[] users, int numUsers, String username, String password) {
        for (int i = 0; i < numUsers; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String outputFile = "E:\\java\\user5.csv";
        String inputFile = "E:\\java\\user5.csv";
        Scanner scanner = new Scanner(System.in);

        User[] users = new User[100];
        int numUsers = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                PersonalDetails personalDetails = new PersonalDetails();
                personalDetails.name = data[2];
                personalDetails.fatherName = data[3];
                personalDetails.motherName = data[4];
                personalDetails.dob = data[5];
                personalDetails.gender = data[6].charAt(0);
                try {
                    personalDetails.age = Integer.parseInt(data[7]);
                    personalDetails.height = Integer.parseInt(data[8]);
                    personalDetails.weight = Integer.parseInt(data[9]);
                    personalDetails.Occupation = data[10];
                    personalDetails.setSalary(Integer.parseInt(data[11]));
                    personalDetails.Education = data[12];
                    personalDetails.setResidence(data[13]);
                    personalDetails.motongue = data[14];
                    personalDetails.Religion = data[15];
                    personalDetails.caste = data[16];

                    if (data[17] != null && !data[17].isEmpty() && !"null".equalsIgnoreCase(data[17])) {
                        personalDetails.setPhone(Long.parseLong(data[17]));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing numeric value: " + e.getMessage());
                    continue;
                }

                users[numUsers] = new User(data[0], data[1], personalDetails);
                numUsers++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(outputFile, true)) { ////////// if it is true then it will append
                                                                         ////////// the data to the file
            if (Files.size(Paths.get(outputFile)) == 0) { //////////////////////////////////// Paths.get(outputFile)---
                                                          //////////////////////////////////// gives the path of the
                                                          //////////////////////////////////// OutputFile and then
                                                          //////////////////////////////////// checking filesize
                fileWriter.write(
                        "Username,Password,Name,Father's Name,Mother's Name,Date of Birth,Gender,Age,Height,Weight,Occupation,Salary,Education,Residence,Mother Tongue,Religion,Caste,Phone\n");
            }

            while (true) {
                System.out.println("<--- Choose the Option --->");
                System.out.println("1) Register");
                System.out.println("2) Login");
                System.out.println("3) Exit");
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerUser(scanner, fileWriter, users, numUsers);
                        numUsers++;
                        break;
                    case 2:
                        boolean loggedIn = loginUser(scanner, users, numUsers);
                        if (loggedIn) {

                            while (true) {
                                System.out.println("Enter your choice:");
                                System.out.println("1) Display Compatible Users");
                                System.out.println("2) Edit Personal Details");
                                System.out.println("3) Exit");

                                int choice1 = scanner.nextInt();
                                scanner.nextLine();
                                //// main home-page
                                switch (choice1) {
                                    case 1:
                                        if (numUsers > 0) {
                                            System.out.println("Enter your username: ");
                                            String enteredUsername = scanner.nextLine();

                                            System.out.println("Enter your Password: ");
                                            String enteredPassword = scanner.nextLine();

                                            User currentUser = findUserByUsername(users, numUsers, enteredUsername,
                                                    enteredPassword);

                                            if (currentUser != null) {
                                                DisplayCompatibles.displayCompatibleUsers(users, numUsers,
                                                        currentUser.personalDetails);
                                            } else {
                                                System.out.println("<-----------------User not found---------------->");
                                            }
                                        } else {
                                            System.out.println("<-----------No User------------>");
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Enter your username:");
                                        String enteredUsername = scanner.nextLine();

                                        System.out.println("Enter your Password");
                                        String enteredPassword = scanner.nextLine();

                                        User currentUser = findUserByUsername(users, numUsers, enteredUsername,
                                                enteredPassword);

                                        if (currentUser != null) {
                                            currentUser.editPersonalDetails(scanner);
                                        } else {
                                            System.out
                                                    .println("<-------------------User not found-------------------->");
                                        }
                                        break;

                                    case 3:
                                        System.exit(0);
                                        break;

                                    default:
                                        System.out.println("Please enter a valid option:-");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("<------------------Login failed. Please try again---------------->");
                        }

                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("<----------------Please enter a valid option------------------>");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing users file: " + e.getMessage());
        }

        scanner.close();
    }

}
/*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
