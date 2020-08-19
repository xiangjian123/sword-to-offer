package com.company.dp.command;

abstract class Command {
    protected Require require = new Require();
    protected Page page = new Page();
    protected Code code = new Code();
    public abstract void execute();
}

class AddCommand extends Command {
    @Override
    public void execute() {
        super.require.find();
        super.require.add();
        super.require.plan();
    }
}

class DeleteCommand extends Command {
    @Override
    public void execute() {
        super.page.find();
        super.require.delete();
        super.require.plan();
    }
}

class CancelDeleteCommand extends Command {
    @Override
    public void execute() {
        super.page.find();
        super.page.rollback();
    }
}

class Invoker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void action() {
        this.command.execute();
    }
}

class Client {
    public static void main(String[] args) {
        Invoker zhang = new Invoker();
        Command command = new AddCommand();
        command = new DeleteCommand();
        zhang.setCommand(command);
        zhang.action();
    }
}

abstract class Group {
    public abstract void find();
    public abstract void add();
    public abstract void delete();
    public abstract void change();
    public abstract void plan();
    public void rollback() {}
}

class Require extends Group {
    @Override
    public void find() {
        System.out.println(" require find");
    }
    @Override
    public void add() {
        System.out.println(" require add");
    }
    @Override
    public void delete() {
        System.out.println(" require delete");
    }
    @Override
    public void change() {
        System.out.println(" require change");
    }
    @Override
    public void plan() {
        System.out.println(" require plan");
    }
}

class Page extends Group {
    @Override
    public void find() {
        System.out.println("Page find");
    }
    @Override
    public void add() {
        System.out.println(" Page add");
    }
    @Override
    public void delete() {
        System.out.println(" Page delete");
    }
    @Override
    public void change() {
        System.out.println(" Page change");
    }
    @Override
    public void plan() {
        System.out.println(" Page plan");
    }

    @Override
    public void rollback() {
        System.out.println("Page rollback last page");
    }
}

class Code extends Group {
    @Override
    public void find() {
        System.out.println("Code find");
    }
    @Override
    public void add() {
        System.out.println(" Code add");
    }
    @Override
    public void delete() {
        System.out.println(" Code delete");
    }
    @Override
    public void change() {
        System.out.println(" Code change");
    }
    @Override
    public void plan() {
        System.out.println(" Code plan");
    }
}

/**
 * 将请求封装成一个对象，使用不同的请求把客户端参数化，对请求排队或者日志，可以提供命令的撤销和恢复功能
 */
public class DP_Command {
}
