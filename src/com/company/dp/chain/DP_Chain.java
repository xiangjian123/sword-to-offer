package com.company.dp.chain;

abstract class Handler {
    private Handler nextHandler;
    public final Response handleMessage(Request request) {
        Response response = null;
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            if (this.nextHandler != null) {
                response = this.nextHandler.handleMessage(request);
            }
        }
        return response;
    }

    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    protected abstract Level getHandlerLevel();
    protected abstract Response echo(Request request);
}

class H1 extends Handler {
    @Override
    protected Response echo(Request request) {
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return null;
    }
}

class H2 extends Handler {
    @Override
    protected Response echo(Request request) {
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return null;
    }
}
class H3 extends Handler {
    @Override
    protected Response echo(Request request) {
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return null;
    }
}

class Level {
}

class Request {
    public Level getRequestLevel() {
        return null;
    }
}

class Response {
}

class Client {
    public static void main(String[] args) {
        Handler h1 = new H1();
        Handler h2 = new H2();
        Handler h3 = new H3();
        h1.setNext(h2);
        h2.setNext(h3);
        Response response = h1.handleMessage(new Request());
    }
}


public class DP_Chain {
}
