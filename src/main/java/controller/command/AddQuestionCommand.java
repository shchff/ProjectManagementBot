package controller.command;

import controller.Facade;
import model.Question;
import model.Username;
import view.response.Response;

import java.util.ArrayList;
import java.util.Collections;

public class AddQuestionCommand extends Command{
    public AddQuestionCommand(Commands command, ArrayList<String> argsList, String requestUserId) {
        super(command, argsList, requestUserId);
    }

    /**
     * @return
     */
    @Override
    public Response perform() {
        Question question = new Question(getArgsList().get(0), new Username(requestUserId));
        return new Response(Facade.addQuestion(question), new ArrayList<>(Collections.singletonList(requestUserId)));
    }
}
