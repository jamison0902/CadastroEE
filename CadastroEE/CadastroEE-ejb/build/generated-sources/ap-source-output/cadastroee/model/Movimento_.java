package cadastroee.model;

import cadastroee.model.Pessoa;
import cadastroee.model.Produto;
import cadastroee.model.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2023-09-09T11:52:36")
@StaticMetamodel(Movimento.class)
public class Movimento_ { 

    public static volatile SingularAttribute<Movimento, Integer> idMovimento;
    public static volatile SingularAttribute<Movimento, Character> tipo;
    public static volatile SingularAttribute<Movimento, Pessoa> pessoa;
    public static volatile SingularAttribute<Movimento, Produto> produto;
    public static volatile SingularAttribute<Movimento, Usuario> usuario;
    public static volatile SingularAttribute<Movimento, Integer> quantidade;
    public static volatile SingularAttribute<Movimento, BigDecimal> valorUnitario;

}