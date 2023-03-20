import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindTaskOnRequestInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        simpleTask.getTitle();
        // String query = "Позвонить родителям";
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void shouldNotFindTaskOnRequestInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Прием врача");
        simpleTask.getTitle();
        // String query = "Позвонить родителям";
        boolean expected = false;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void shouldFindTaskOnRequestInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        epic.getSubtasks();
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void shouldNotFindTaskOnRequestInEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        epic.getSubtasks();
        boolean expected = false;
        boolean actual = epic.matches("Самовар");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTaskOnRequestInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        meeting.getTopic();
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTaskOnRequestInMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        meeting.getTopic();
        boolean expected = false;
        boolean actual = meeting.matches("Обед");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindTaskOnRequestInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        meeting.getProject();
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTaskOnRequestInMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        meeting.getProject();
        boolean expected = false;
        boolean actual = meeting.matches("Сбор урожая");
        Assertions.assertEquals(expected, actual);

    }

}
