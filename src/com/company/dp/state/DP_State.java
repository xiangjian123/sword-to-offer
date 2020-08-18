package com.company.dp.state;


abstract class AbstractLiftState {
    protected StateContext context;
    public void setContext(StateContext c) {
        this.context = c;
    }
    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}

class OpenningState extends AbstractLiftState {
    @Override
    public void close() {
        super.context.setLiftState(StateContext.closingState);
        super.context.getLiftState().close();
    }

    @Override
    public void open() {
        System.out.println("lift is opening");
    }

    @Override
    public void run() {
        //System.out.println("lift is opening");
    }

    @Override
    public void stop() {
        //System.out.println("lift is opening");
    }
}

class ClosingState extends AbstractLiftState {
    @Override
    public void close() {
        System.out.println("lift is closing");

    }

    @Override
    public void open() {
        super.context.setLiftState(StateContext.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(StateContext.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(StateContext.stoppingState);
        super.context.getLiftState().stop();
    }
}

class RunningState extends AbstractLiftState {
    @Override
    public void close() {
    }

    @Override
    public void open() {
    }

    @Override
    public void run() {
        System.out.println("lift is running");
    }

    @Override
    public void stop() {
        super.context.setLiftState(StateContext.stoppingState);
        super.context.getLiftState().stop();
    }
}

class StoppingState extends AbstractLiftState {
    @Override
    public void close() {
    }

    @Override
    public void open() {
        super.context.setLiftState(StateContext.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void run() {
        super.context.setLiftState(StateContext.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("lift is stopping");
    }
}


class StateContext {
    public final static OpenningState openningState = new OpenningState();
    public final static ClosingState closingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();
    private AbstractLiftState liftState;

    public AbstractLiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(AbstractLiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}

public class DP_State {
    public static void main(String[] args) {
        StateContext context = new StateContext();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}

/**
 * State 抽象状态角色，状态定义和封装环境以实现状态切换
 * ConcreteState 具体状态角色，本状态行为管理和趋向状态处理
 * Context 环境，定义需要的接口，并且负责具体状态的切换
 *
 */

abstract class State {
    protected Context context;
    public void setContext(Context _context) {
        this.context = _context;
    }

    public abstract void handle1();
    public abstract void handle2();
}

class ConcreteState1 extends State {
    @Override
    public void handle1() {
        //
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.STATE2);
        super.context.handle2();
    }
}

class ConcreteState2 extends State {
    @Override
    public void handle1() {
        super.context.setCurrentState(Context.STATE1);
        super.context.handle1();
    }

    @Override
    public void handle2() {
        //
    }
}


class Context {
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();

    private State currentState;
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}

class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteState1());
        context.handle1();
        context.handle2();
    }
}




