/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mehamood.ecommerce.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehamood.ecommerce.persistence.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
