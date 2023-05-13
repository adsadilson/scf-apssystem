package br.com.apssystem.scfapssystem.domain.utils;

import com.github.javafaker.Faker;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;

public class CpfCnpjFaker implements ConstraintValidator<ValidationCpfCnpj, String> {

   public Faker getRandomValue() {
      return new Faker(new Locale("PT-BR"));
   }

   public static int randomiza(int n) {
      return (int) (Math.random() * n);
   }

   public static int mod(int dividendo, int divisor) {
      return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
   }

   public static String cpf(boolean comPontos) {
      int n = 9;
      int n1 = randomiza(n);
      int n2 = randomiza(n);
      int n3 = randomiza(n);
      int n4 = randomiza(n);
      int n5 = randomiza(n);
      int n6 = randomiza(n);
      int n7 = randomiza(n);
      int n8 = randomiza(n);
      int n9 = randomiza(n);
      int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

      d1 = 11 - (mod(d1, 11));

      if (d1 >= 10)
         d1 = 0;

      int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

      d2 = 11 - (mod(d2, 11));

      String retorno;

      if (d2 >= 10)
         d2 = 0;

      if (comPontos)
         retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
      else
         retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

      return retorno;
   }

   public static String cnpj(boolean comPontos) {
      int n = 9;
      int n1 = randomiza(n);
      int n2 = randomiza(n);
      int n3 = randomiza(n);
      int n4 = randomiza(n);
      int n5 = randomiza(n);
      int n6 = randomiza(n);
      int n7 = randomiza(n);
      int n8 = randomiza(n);
      int n9 = 0;
      int n10 = 0;
      int n11 = 0;
      int n12 = 1;
      int d1 = n12 * 2 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

      d1 = 11 - (mod(d1, 11));

      if (d1 >= 10)
         d1 = 0;

      int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

      d2 = 11 - (mod(d2, 11));

      if (d2 >= 10)
         d2 = 0;

      String retorno;

      if (comPontos)
         retorno = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2;
      else
         retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

      return retorno;
   }


   public static String rg(boolean comPontos) {

      String numerosContatenados;
      String numeroGerado;
      Random numeroAleatorio;
      numeroAleatorio = new Random();
      //numeros gerados
      int n1 = numeroAleatorio.nextInt(10);
      int n2 = numeroAleatorio.nextInt(10);
      int n3 = numeroAleatorio.nextInt(10);
      int n4 = numeroAleatorio.nextInt(10);
      int n5 = numeroAleatorio.nextInt(10);
      int n6 = numeroAleatorio.nextInt(10);
      int n7 = numeroAleatorio.nextInt(10);
      int n8 = numeroAleatorio.nextInt(10);
      int n9 = numeroAleatorio.nextInt(10);

      //Conctenando os numeros
      numerosContatenados = String.valueOf(n1) + n2 + n3 + n4 +
              n5 + n6 + n7 + n8 +
              n9;

      if (comPontos)
         numeroGerado = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "-" + n9;
      else
         numeroGerado = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9;

      return numeroGerado;
   }

   public static boolean isCPF(String CPF) {

      CPF = removeCaracteresEspeciais(CPF);

      // considera-se erro CPF's formados por uma da sequência de números iguais
      if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
         return (false);

      char dig10;
      char dig11;
      int sm;
      int i;
      int r;
      int num;
      int peso;

      // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
      try {
         // Calculo do 1. Digito Verificador
         sm = 0;
         peso = 10;
         for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = CPF.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
         }

         r = 11 - (sm % 11);
         if ((r == 10) || (r == 11))
            dig10 = '0';
         else
            dig10 = (char) (r + 48); // converte no respectivo caractere numerico

         // Calculo do (2ª). Digito Verificador
         sm = 0;
         peso = 11;
         for (i = 0; i < 10; i++) {
            num = CPF.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
         }

         r = 11 - (sm % 11);
         if ((r == 10) || (r == 11))
            dig11 = '0';
         else
            dig11 = (char) (r + 48);

         // Verifica se os digitos calculados conferem com os digitos informados.
         return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
      } catch (InputMismatchException erro) {
         return (false);
      }
   }

   public static boolean isCNPJ(String cnpj) {

      cnpj = removeCaracteresEspeciais(cnpj);

      // considera-se erro cnpj's formados por uma da sequência de números iguais
      if (cnpj.equals("00000000000000") ||
              cnpj.equals("11111111111111") ||
              cnpj.equals("22222222222222") ||
              cnpj.equals("33333333333333") ||
              cnpj.equals("44444444444444") ||
              cnpj.equals("55555555555555") ||
              cnpj.equals("66666666666666") ||
              cnpj.equals("77777777777777") ||
              cnpj.equals("88888888888888") ||
              cnpj.equals("99999999999999") ||
              (cnpj.length() != 14))
         return (false);

      char dig13;
      char dig14;
      int sm;
      int i;
      int r;
      int num;
      int peso;

      // "try" - protege o código para eventuais erros de conversao de tipo (int)
      try {
         // Calculo do 1.º. Digito Verificador
         sm = 0;
         peso = 2;
         for (i = 11; i >= 0; i--) {
            // converte o i-ésimo caractere do cnpj em uns números:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
            num = cnpj.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
               peso = 2;
         }

         r = sm % 11;
         if ((r == 0) || (r == 1))
            dig13 = '0';
         else
            dig13 = (char) ((11 - r) + 48);

         // Calculo do 2. Digito Verificador
         sm = 0;
         peso = 2;
         for (i = 12; i >= 0; i--) {
            num = cnpj.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
               peso = 2;
         }

         r = sm % 11;
         if ((r == 0) || (r == 1))
            dig14 = '0';
         else
            dig14 = (char) ((11 - r) + 48);

         // Verifica se os dígitos calculados conferem com os dígitos informados.
         return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
      } catch (InputMismatchException erro) {
         return (false);
      }
   }

   public static String removeCaracteresEspeciais(String doc) {
      if (doc.contains(".")) {
         doc = doc.replace(".", "");
      }
      if (doc.contains("-")) {
         doc = doc.replace("-", "");
      }
      if (doc.contains("/")) {
         doc = doc.replace("/", "");
      }
      return doc;
   }

   public static String imprimeCNPJ(String CNPJ) {
      // máscara do CNPJ: 99.999.999.9999-99
      return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14));
   }

   @Override
   public void initialize(ValidationCpfCnpj constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      return value == null || value.isEmpty() || isCPF(value) || isCNPJ(value);
   }
}
