
import java.util.*;
public class atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nameInput = scanner.nextLine();
        nama name = new nama(nameInput);

        System.out.print("Masukkan nomor rekening: ");
        String noRekInput = scanner.nextLine();
        rekening rekening = new rekening(noRekInput);

        System.out.print("Masukkan password: ");
        String passwordInput = scanner.nextLine();
        password password = new password(passwordInput);

        saldo saldo = new saldo(1000000.0); 

        System.out.print("Masukkan password untuk mengakses saldo: ");
        String passwordCheck = scanner.nextLine();

        if (passwordCheck.equals(password.getPassword())) {
            System.out.println("Saldo Anda: " + saldo.getSaldo());
            System.out.print("Masukkan jumlah yang ingin diambil: ");
            double amount = scanner.nextDouble();

            if (amount <= saldo.getSaldo()) {
                saldo.setSaldo(saldo.getSaldo() - amount);
                System.out.println("Transaksi berhasil. Saldo baru Anda: " + saldo.getSaldo());
            } else {
                System.out.println("Saldo tidak mencukupi.");
            }
        } else {
            System.out.println("Password salah. Tidak dapat mengakses saldo.");
        }

        scanner.close();
    }

 static class nama {
    private String name;

    public nama(String name) {
        if (name.length() >= 4) {
            this.name = name;
        } else {
            System.out.println("Nama harus memiliki minimal 4 huruf.");
        }
    }


    public String getName() {
        return name;
    }
}

 static class rekening {
    private String noRek;

    public rekening(String noRek) {
        if (noRek.length() >= 8) {
            this.noRek = noRek;
        } else {
            System.out.println("Nomor rekening harus memiliki minimal 8 huruf.");
        }
    }

    public String getNoRek() {
        return noRek;
    }
}

 static class password {
    private String password;

    public password(String password) {
        if (password.length() >= 8 && password.contains("_") && password.matches(".*[A-Z].*")) {
            this.password = password;
        } else {
            System.out.println("Password harus memiliki minimal 8 karakter, mengandung karakter underscore, dan memiliki setidaknya satu huruf kapital.");
        }
    }

    public String getPassword() {
        return password;
    }
 }

 static class saldo {
    private double saldo;

    public saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
}
 
//rekening >=8 huruf
//nama >= 4 huruf
//password >= 8 karakter, harus ada karakter underscore, harus ada 1 huruf kapital 
//ketika mengakses saldo, harus memasukkan password yang benar
//saldo yang diambil tidak boleh melebihi saldo yang ada di rekening