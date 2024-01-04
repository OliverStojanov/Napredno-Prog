package Zad45;

public class CreditScore extends ChainEvaluator {
    public CreditScore(Evaluator next) {
        super(next);
    }
    @Override
    public boolean evaluate(Applicant applicant) {
        if (applicant.getCreditScore() < 500) {
            return false;
        } else if (hasNext()) {
            return super.evaluate(applicant);
        } else return true;
    }
}
