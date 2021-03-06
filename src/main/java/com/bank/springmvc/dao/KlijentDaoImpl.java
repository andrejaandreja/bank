/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.springmvc.dao;

import com.bank.springmvc.model.Klijent;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andreja
 */
@Repository("klijentDao")
public class KlijentDaoImpl extends AbstractDao<Integer, Klijent> implements KlijentDao{

    public Klijent findById(int id) {
        return getByKey(id);
    }

    public void saveClient(Klijent client) {
        persist(client);
    }

    public void deleteClientById(int klijent_id) {
        Query query = getSession().createSQLQuery("delete from Klijent where jmbg = :jmbg");
        query.setString("klijent_id", String.valueOf(klijent_id));
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Klijent> findAllClients() {
        Criteria criteria = createEntityCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Klijent>) criteria.list();
    }

    public Klijent findClientById(int klijent_id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("klijent_id", klijent_id));
        return (Klijent) criteria.uniqueResult();
    }
    
    
    
}
