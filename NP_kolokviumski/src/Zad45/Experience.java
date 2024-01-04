package Zad45;

public class Experience extends ChainEvaluator {
    public Experience(Evaluator next) {
        super(next);
    }

    @Override
    public boolean evaluate(Applicant applicant) {
        if (applicant.getEmploymentYears() < 10) {
            return false;
        } else {
            if (hasNext()) return super.evaluate(applicant);
            else return true;
        }
    }
}
