package br.com.java.kernel.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.java.kernel.model.dao.UsuarioDao;
import br.com.java.kernel.model.entity.seguranca.Usuario;


@Repository("usuarioDao")
public class UsuarioDaoImpl extends DaoGenericoImp<Usuario, Integer> implements UsuarioDao {

}
