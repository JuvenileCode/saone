package com.bademo.jpa.service;

import com.bademo.jpa.JpaUtil;
import com.bademo.jpa.model.SqtckModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/11/9 0009.16:30
 */
public interface SqtckService extends JpaRepository<SqtckModel,Integer>,JpaSpecificationExecutor<SqtckModel>{

    List<SqtckModel> findByPriceAndNumberLessThan(BigDecimal price, BigDecimal number);

    //spring-data-jpa [JpaSpecificationExecutor] 动态查询测试
    default List<SqtckModel> findDynamic(SqtckModel par){
        Specification querySpecifi = (Specification<SqtckModel>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(!StringUtils.isEmpty(par.getPaper())){
                predicates.add(cb.equal(root.get("paper"),par.getPaper()));
            }
            if (par.getPcid() > 0){
                predicates.add(cb.equal(root.get("pcid"),par.getPcid()));
            }
            if (par.getNumber() != null && par.getNumber().compareTo(BigDecimal.ZERO) > 0) {
                predicates.add(cb.gt(root.get("number"), par.getNumber()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        //非lambda样式代码
        /*Specification querySpecifi = new Specification<SqtckModel>(){
            @Override
            public Predicate toPredicate(Root<SqtckModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                return null;
            }
        };*/
        //return this.findAll(querySpecifi);
        //自己封装JPA Util动态查询
        return this.findAll(new JpaUtil<SqtckModel>().and(JpaUtil.Cnd.eq("paper", par.getPaper())
                , JpaUtil.Cnd.eq("pcid", par.getPcid()), JpaUtil.Cnd.gt("number", par.getNumber())));
    }
}
