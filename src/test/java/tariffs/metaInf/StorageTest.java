package tariffs.metaInf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tariffs.model.Operator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private Storage storage;
    private static final String FILE_STORAGE_NAME = "data.xml";

    @BeforeEach
    void init(){
        storage = new Storage();
    }

    @Nested
    class AddOperatorTest {
        private static final String NAME = "MaxAndMin";
        private Operator operator = new Operator(NAME);
        @Test
        void  add_AddOperator_Success(){
            storage.addOperator(operator);

            List<Operator> operators = storage.getAllOperators();
            assertEquals(1, operators.size());
        }
    }

    @Nested
    class RemoveOperatorTest {
        private static final String NAME = "MaxAndMin";
        List<Operator> actualList = new ArrayList<>();
        private final Integer INDEX = 0;
        Operator operator1 = new Operator(NAME);

        @Test
        void rem_RemoveOperator_Success (){
             actualList.add(operator1);
             actualList.add(operator1);

             storage.addOperator(operator1);
             storage.addOperator(operator1);

             storage.removeOperator(INDEX);
             actualList.remove(1);

             List<Operator> operators = storage.getAllOperators();
             assertEquals(actualList.size(), operators.size());

         }
    }

    @Nested
    class GetAllOperatorsTest {
        private static final String NAME = "MaxAndMin";
        List<Operator> actualList = new ArrayList<>();
        Operator operator1 = new Operator(NAME);

        @Test
        void get_GetAllOperators_Success(){
            actualList.add(operator1);
            actualList.add(operator1);

            storage.addOperator(operator1);
            storage.addOperator(operator1);

            List<Operator> operators = storage.getAllOperators();
            assertEquals(actualList.size(), operators.size());


            assertEquals(actualList, storage.getAllOperators());
        }
    }
}