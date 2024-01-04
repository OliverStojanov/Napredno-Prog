package Zad45;

public abstract class ChainEvaluator implements Evaluator{
    private final Evaluator next;

    public ChainEvaluator(Evaluator next) {
        this.next = next;
    }

    protected boolean hasNext(){
        return next!=null;
    }

    @Override
    public boolean evaluate(Applicant applicant) {
        return next.evaluate(applicant);
    }
}
