package Zad45;

public class CriminalRecord extends ChainEvaluator {
    public CriminalRecord(Evaluator next) {
        super(next);
    }
    @Override
    public boolean evaluate(Applicant applicant) {
        if (applicant.hasCriminalRecord()) {
            return false;
        }
        if (hasNext()) {
            return super.evaluate(applicant);
        } else return true;
    }

}
