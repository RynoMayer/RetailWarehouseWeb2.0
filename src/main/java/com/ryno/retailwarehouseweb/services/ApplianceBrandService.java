/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.services;

import com.ryno.retailwarehouseweb.domain.Appliance;
import java.util.List;

/**
 *
 * @author Ryno
 */
public interface ApplianceBrandService {
    public List<Appliance> getBrandStart(String letter);
}
