/**
 * copyRight
 */
package com.liuz.beancontext;

import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.beancontext.BeanContext;
import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextMembershipListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/29
 * Time: 10:47
 */
public class BeanContextApi implements BeanContext {

    @Override
    public Object instantiateChild(String beanName) throws IOException, ClassNotFoundException {

        return null;
    }

    @Override
    public InputStream getResourceAsStream(String name, BeanContextChild bcc) throws IllegalArgumentException {
        return null;
    }

    @Override
    public URL getResource(String name, BeanContextChild bcc) throws IllegalArgumentException {

        return null;
    }

    @Override
    public void addBeanContextMembershipListener(BeanContextMembershipListener bcml) {

    }

    @Override
    public void removeBeanContextMembershipListener(BeanContextMembershipListener bcml) {

    }

    @Override
    public void setDesignTime(boolean designTime) {

    }

    @Override
    public boolean isDesignTime() {

        return false;
    }

    @Override
    public boolean needsGui() {

        return false;
    }

    @Override
    public void dontUseGui() {

    }

    @Override
    public void okToUseGui() {

    }

    @Override
    public boolean avoidingGui() {

        return false;
    }

    @Override
    public void setBeanContext(BeanContext bc) throws PropertyVetoException {

    }

    @Override
    public BeanContext getBeanContext() {

        return null;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener pcl) {

    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener pcl) {

    }

    @Override
    public void addVetoableChangeListener(String name, VetoableChangeListener vcl) {

    }

    @Override
    public void removeVetoableChangeListener(String name, VetoableChangeListener vcl) {

    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public Iterator iterator() {

        return null;
    }

    @Override
    public Object[] toArray() {

        return new Object[0];
    }

    @Override
    public boolean add(Object o) {

        return false;
    }

    @Override
    public boolean remove(Object o) {

        return false;
    }

    @Override
    public boolean addAll(Collection c) {

        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection c) {

        return false;
    }

    @Override
    public boolean containsAll(Collection c) {

        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {

        return new Object[0];
    }
}
