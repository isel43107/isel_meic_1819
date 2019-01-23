/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.webfilter;

import javax.servlet.annotation.WebFilter;

/**
 *
 * @author pauloborges
 */
@WebFilter(urlPatterns = {"/websocket/*"})
public class AuthFilter{
    
}
