package br.com.rogerio.persistencia;

import br.com.rogerio.modelo.Aluno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class AlunoDal {

    private String nomeDoArquivo;

    public AlunoDal(String nome) {
        nomeDoArquivo = nome;
    }

    public ArrayList<Aluno> listarAlunos() throws Exception {

        try {
            ArrayList<Aluno> array = new ArrayList<Aluno>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;

            while ((linha = br.readLine()) != null) {
                Aluno aux = new Aluno(linha);
                array.add(aux);
                pos++;
            }
            br.close();

            // método de ordenação bolha
            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {
                    if (array.get(i).getNome().compareToIgnoreCase(array.get(j).getNome()) >= 0) {
                        Aluno temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }
            // retorna o array ordenado por nome
            return array;

        } catch (Exception erro) {
            throw new Exception("Arquivo de alunos não encontrado\n" + erro.getMessage());
        }
    }
}
