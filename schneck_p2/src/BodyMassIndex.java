public class BodyMassIndex {
    double bmiScore;
    String bmiCategory;
    

    public BodyMassIndex(double height, double weight) {
        this.bmiScore = calculateBmiScore(height, weight);
        this.bmiCategory = calculateBmiCategory(this.bmiScore);

    }

    public double calculateBmiScore(double height, double weight) {
        return 703 * height / (weight * weight);
    }

    public String calculateBmiCategory(double bmiScore) {
        if (bmiScore <= 18.5) {
            return "Underweight"; 
        }

        else {
            if (bmiScore <= 24.9) {
                return "Normal Weight";
            }

            else {
                if (bmiScore <= 29.9) {
                    return "Overweight";
                }

                else {
                    return "Obesity";
                }
            }
        }

    }
}
