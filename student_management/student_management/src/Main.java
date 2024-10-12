import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseSave dbSave = new DatabaseSave();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Студенты");
            System.out.println("2. Преподаватели");
            System.out.println("3. Оценки");
            System.out.println("4. Курсы");
            System.out.println("5. Учебные группы");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Студенты
                    handleStudents(dbSave, scanner);
                    break;
                case 2: // Преподаватели
                    handleTeachers(dbSave, scanner);
                    break;
                case 3: // Оценки
                    handleGrades(dbSave, scanner);
                    break;
                case 4: // Курсы
                    handleCourses(dbSave, scanner);
                    break;
                case 5: // Учебные группы
                    handleStudyGroups(dbSave, scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void handleStudents(DatabaseSave dbSave, Scanner scanner) {
        int choice;
        do {
            System.out.println("Студенты:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Список студентов");
            System.out.println("4. Найти студента по ID");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Для очистки буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст студента: ");
                    int age = scanner.nextInt();
                    System.out.print("Введите ID учебной группы: ");
                    int groupId = scanner.nextInt();
                    dbSave.addStudent(name, age, groupId);
                    break;
                case 2:
                    System.out.print("Введите ID студента для удаления: ");
                    int studentId = scanner.nextInt();
                    dbSave.deleteStudent(studentId);
                    break;
                case 3:
                    dbSave.listStudents();
                    break;
                case 4:
                    System.out.print("Введите ID студента для поиска: ");
                    studentId = scanner.nextInt();
                    dbSave.findStudentById(studentId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }

    private static void handleTeachers(DatabaseSave dbSave, Scanner scanner) {
        int choice;
        do {
            System.out.println("Преподаватели:");
            System.out.println("1. Добавить преподавателя");
            System.out.println("2. Удалить преподавателя");
            System.out.println("3. Список преподавателей");
            System.out.println("4. Найти преподавателя по ID");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Для очистки буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя преподавателя: ");
                    String teacherName = scanner.nextLine();
                    dbSave.addTeacher(teacherName);
                    break;
                case 2:
                    System.out.print("Введите ID преподавателя для удаления: ");
                    int teacherId = scanner.nextInt();
                    dbSave.deleteTeacher(teacherId);
                    break;
                case 3:
                    dbSave.listTeachers();
                    break;
                case 4:
                    System.out.print("Введите ID преподавателя для поиска: ");
                    teacherId = scanner.nextInt();
                    dbSave.findTeacherById(teacherId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }

    private static void handleGrades(DatabaseSave dbSave, Scanner scanner) {
        int choice;
        do {
            System.out.println("Оценки:");
            System.out.println("1. Добавить оценку");
            System.out.println("2. Удалить оценку");
            System.out.println("3. Список оценок");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите ID студента: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Введите ID курса: ");
                    int courseId = scanner.nextInt();
                    System.out.print("Введите оценку: ");
                    double grade = scanner.nextDouble();
                    dbSave.addGrade(studentId, courseId, grade);
                    break;
                case 2:
                    System.out.print("Введите ID оценки для удаления: ");
                    int gradeId = scanner.nextInt();
                    dbSave.deleteGrade(gradeId);
                    break;
                case 3:
                    System.out.print("Введите ID студента для получения списка оценок: ");
                    studentId = scanner.nextInt();
                    dbSave.listGrades(studentId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }

    private static void handleCourses(DatabaseSave dbSave, Scanner scanner) {
        int choice;
        do {
            System.out.println("Курсы:");
            System.out.println("1. Добавить курс");
            System.out.println("2. Удалить курс");
            System.out.println("3. Список курсов");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Для очистки буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите название курса: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Введите часы курса: ");
                    int credits = scanner.nextInt();
                    dbSave.addCourse(courseName, credits);
                    break;
                case 2:
                    System.out.print("Введите ID курса для удаления: ");
                    int courseId = scanner.nextInt();
                    dbSave.deleteCourse(courseId);
                    break;
                case 3:
                    dbSave.listCourses();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }

    private static void handleStudyGroups(DatabaseSave dbSave, Scanner scanner) {
        int choice;
        do {
            System.out.println("Учебные группы:");
            System.out.println("1. Добавить учебную группу");
            System.out.println("2. Удалить учебную группу");
            System.out.println("3. Список учебных групп");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Для очистки буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите название учебной группы: ");
                    String groupName = scanner.nextLine();
                    dbSave.addStudyGroup(groupName);
                    break;
                case 2:
                    System.out.print("Введите ID учебной группы для удаления: ");
                    int groupId = scanner.nextInt();
                    dbSave.deleteStudyGroup(groupId);
                    break;
                case 3:
                    dbSave.listStudyGroups();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);
    }
}