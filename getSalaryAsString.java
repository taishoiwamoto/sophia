public String getSalaryAsString() {
  // Format salary with leading dollar sign and 2 decimal places
  DecimalFormat salaryFormat = new DecimalFormat("$0.00");
  // Use getSalary to get numeric value and then format
  return salaryFormat.format(getSalary());
}