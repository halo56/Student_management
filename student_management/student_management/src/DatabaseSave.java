import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSave {
    private Database database;

    public DatabaseSave() {
        database = new Database();
    }

    // Метод для добавления студента
    public void addStudent(String name, int age, int groupId) {
        String query = "INSERT INTO Students (name, age, group_id) VALUES (?, ?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, groupId);
            statement.executeUpdate();
            System.out.println("Студент добавлен.");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления студента: " + e.getMessage());
        }
    }

    // Метод для удаления студента
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
            System.out.println("Студент удален.");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления студента: " + e.getMessage());
        }
    }

    // Метод для получения списка студентов
    public void listStudents() {
        String query = "SELECT * FROM Students";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Список студентов:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Имя: " + resultSet.getString("name") + ", Возраст: " + resultSet.getInt("age") + ", ID группы: " + resultSet.getInt("group_id"));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения списка студентов: " + e.getMessage());
        }
    }

    // Метод для поиска студента по ID
    public void findStudentById(int studentId) {
        String query = "SELECT * FROM Students WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Найденный студент: ID: " + resultSet.getInt("id") + ", Имя: " + resultSet.getString("name") + ", Возраст: " + resultSet.getInt("age") + ", ID группы: " + resultSet.getInt("group_id"));
            } else {
                System.out.println("Студент не найден.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка поиска студента: " + e.getMessage());
        }
    }

    // Реализуйте аналогичные методы для других таблиц (Teachers, Courses, Grades, StudyGroups)
    // Например, методы для Teachers
    public void addTeacher(String name) {
        String query = "INSERT INTO Teachers (name) VALUES (?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Преподаватель добавлен.");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления преподавателя: " + e.getMessage());
        }
    }

    public void deleteTeacher(int teacherId) {
        String query = "DELETE FROM Teachers WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teacherId);
            statement.executeUpdate();
            System.out.println("Преподаватель удален.");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления преподавателя: " + e.getMessage());
        }
    }

    public void listTeachers() {
        String query = "SELECT * FROM Teachers";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Список преподавателей:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Имя: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения списка преподавателей: " + e.getMessage());
        }
    }

    public void findTeacherById(int teacherId) {
        String query = "SELECT * FROM Teachers WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, teacherId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Найденный преподаватель: ID: " + resultSet.getInt("id") + ", Имя: " + resultSet.getString("name"));
            } else {
                System.out.println("Преподаватель не найден.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка поиска преподавателя: " + e.getMessage());
        }
    }

    // Добавление курса
    public void addCourse(String name, int credits) {
        String query = "INSERT INTO Courses (name, credits) VALUES (?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, credits);
            statement.executeUpdate();
            System.out.println("Курс добавлен.");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления курса: " + e.getMessage());
        }
    }

    // Удаление курса
    public void deleteCourse(int courseId) {
        String query = "DELETE FROM Courses WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courseId);
            statement.executeUpdate();
            System.out.println("Курс удален.");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления курса: " + e.getMessage());
        }
    }

    // Список курсов
    public void listCourses() {
        String query = "SELECT * FROM Courses";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Список курсов:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Название: " + resultSet.getString("name") + ", часов: " + resultSet.getInt("credits"));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения списка курсов: " + e.getMessage());
        }
    }

    // Добавление учебной группы
    public void addStudyGroup(String name) {
        String query = "INSERT INTO StudyGroups (name) VALUES (?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Учебная группа добавлена.");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления учебной группы: " + e.getMessage());
        }
    }
    // Удаление учебной группы
    public void deleteStudyGroup(int groupId) {
        String query = "DELETE FROM StudyGroups WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, groupId);
            statement.executeUpdate();
            System.out.println("Учебная группа удалена.");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления учебной группы: " + e.getMessage());
        }
    }

    // Список учебных групп
    public void listStudyGroups() {
        String query = "SELECT * FROM StudyGroups";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("Список учебных групп:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Название: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения списка учебных групп: " + e.getMessage());
        }
    }

    // Добавление оценки
    public void addGrade(int studentId, int courseId, double grade) {
        String query = "INSERT INTO Grades (student_id, course_id, grade) VALUES (?, ?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setDouble(3, grade);
            statement.executeUpdate();
            System.out.println("Оценка добавлена.");
        } catch (SQLException e) {
            System.err.println("Ошибка добавления оценки: " + e.getMessage());
        }
    }

    // Удаление оценки
    public void deleteGrade(int gradeId) {
        String query = "DELETE FROM Grades WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, gradeId);
            statement.executeUpdate();
            System.out.println("Оценка удалена.");
        } catch (SQLException e) {
            System.err.println("Ошибка удаления оценки: " + e.getMessage());
        }
    }

    // Список оценок для студента
    public void listGrades(int studentId) {
        String query = "SELECT * FROM Grades WHERE student_id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                System.out.println("Оценки студента с ID " + studentId + ":");
                while (resultSet.next()) {
                    System.out.println("Курс ID: " + resultSet.getInt("course_id") + ", Оценка: " + resultSet.getDouble("grade"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения оценок: " + e.getMessage());
        }
    }

}
