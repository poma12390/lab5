package lab5.common.dto;

import lab5.common.Worker;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class CommandResponseDto<T extends Serializable> implements Serializable {
    private String response;
    private Worker worker;

    public T getCommandArgs() {
        return commandArgs;
    }

    public void setCommandArgs(T commandArgs) {
        this.commandArgs = commandArgs;
    }

    private T commandArgs;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public CommandResponseDto(T commandArgs) {
        this.commandArgs = commandArgs;
    }
}
