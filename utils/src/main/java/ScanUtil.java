import java.util.Scanner;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.lang.*;

public class ScanUtil {

	private static Scanner scanInput = new Scanner(System.in).useDelimiter("\n");

	public static String scanString() {
		return scanInput.nextLine();
	}

	public static int scanInt() {
		return scanInput.nextInt();
	}

	public static Long scanLong(String prompt) {
		boolean redo = true;
		String input = scanString();
		Long d = 0L;
		while(redo) {
			try {
				d = Long.parseLong(input);
				redo = false;
			} catch(Exception e) {
				System.out.println("Invalid input. Please try again. ");
		    	System.out.print(prompt);
		    	input = scanString();
			}
		}
		return d;	
	}

	public static int scanValidInput(String option, int min, int max) {
		int input = 0;
		boolean inputValidate = false;
		 do {
            try {
                input = scanInput.nextInt();
                if (input >= min && input <= max) {
                    inputValidate = true;
                } else {
                   	System.out.println("Invalid input. Please try again. ");
		    		System.out.print("Select" + option + "action to proceed: ");
                    scanInput.nextLine();
                }
            } catch (InputMismatchException exception) {
               	System.out.println("Invalid input. Please try again. ");
		    	System.out.print("Select" + option + "action to proceed: ");
                scanInput.nextLine();
            }

        } while (!(inputValidate));

        return input;
	}

	public static void flushScanner() {
		scanInput = new Scanner(System.in).useDelimiter("\n");
	}

	public static LocalDate scanDate(String wscan) {
		String bdaystring = scanString();
		LocalDate birthdate = LocalDate.now();
		boolean redo = true;
		while(redo) {
			try {
				birthdate = LocalDate.parse(bdaystring);
				redo = false;
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(wscan + "(YYYY-MM-D): ");
				bdaystring = scanString();
			}
		}
		return birthdate;
	}

	public static Date scanDateU(String wscan, Date old) {
		String bdaystring = scanString();
		if(bdaystring == null || bdaystring.isEmpty()) {
			return old;
		}
		LocalDate birthdate = LocalDate.now();
		boolean redo = true;
		while(redo) {
			try {
				birthdate = LocalDate.parse(bdaystring);
				redo = false;
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(wscan + "(YYYY-MM-D): ");
				bdaystring = scanString();
				if(bdaystring == null || bdaystring.isEmpty()) {
					return old;
				}
			}
		}
		return java.sql.Date.valueOf(birthdate);
	}

	public static String scanCharOnly(String again) {
		boolean redo = true;
		String str = scanString();
		while(redo) {
			try {
				if (!str.matches("[a-zA-Z ]+")) {
				    System.out.println("Invalid input. Please try again. ");
				    System.out.print(again);
				    str = scanString();
				} else {
					redo = false;
				}
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
			}
		}
		return str;
	}

	public static String scanCharOnlyU(String again, String old) {
		boolean redo = true;
		String str = scanString();
		if(str == null || str.isEmpty()) {
			return old;
		}
		while(redo) {
			try {
				if (!str.matches("[a-zA-Z ]+")) {
				    System.out.println("Invalid input. Please try again. ");
				    System.out.print(again);
				    str = scanString();
				} else {
					redo = false;
				}
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
				if(str == null || str.isEmpty()) {
					return old;
				}
			}
		}
		return str;
	}

	public static String scanVarCharOnly(String again) {
		boolean redo = true;
		String str = scanString();
		while(redo) {
			try {
				if (!str.matches("[a-zA-Z0-9 ]+")) {
				    System.out.println("Invalid input. Please try again. ");
				    System.out.print(again);
				    str = scanString();
				} else {
					redo = false;
				}
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
			}
		}
		return str;
	}

	public static String scanVarCharOnlyU(String again, String old) {
		boolean redo = true;
		String str = scanString();
		if(str == null || str.isEmpty()) {
			return old;
		}
		while(redo) {
			try {
				if (!str.matches("[a-zA-Z0-9 ]+")) {
				    System.out.println("Invalid input. Please try again. ");
				    System.out.print(again);
				    str = scanString();
				} else {
					redo = false;
				}
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
				if(str == null || str.isEmpty()) {
					return old;
				}
			}
		}
		return str;
	}

	public static Double scanDoubleOnly(String again) {
		boolean redo = true;
		String str = scanString();
		Double d = 0.0;
		while(redo) {
			try {
				d = Double.parseDouble(str);
				redo = false;
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
			}
		}
		return d;
	}

	public static Double scanDoubleOnlyU(String again, Double old) {
		boolean redo = true;
		String str = scanString();
		if(str == null || str.isEmpty()) {
			return old;
		}
		Double d = 0.0;
		while(redo) {
			try {
				d = Double.parseDouble(str);
				redo = false;
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
				if(str == null || str.isEmpty()) {
					return old;
				}
			}
		}
		return d;
	}

	public static int scanNumOnly(String again) {
		boolean redo = true;
		String str = scanString();
		int num = 0;
		while(redo) {
			try {
				num = Integer.parseInt(str);
				redo = false;
			} catch (Exception e){
				System.out.println("Invalid input. Please try again. ");
				System.out.print(again);
				str = scanString();
			}
		}
		return num;
	}

}