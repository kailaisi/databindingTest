package com.tcsl.databindingtest.lib.imageLoader;

import junit.framework.TestCase;


/**
 * 描述:图片加载类型的测试类
 * <p/>作者：wjx
 * <p/>创建时间: 2017/3/9 15:04
 */
public class ImageLoaderStrategyManagerTest extends TestCase {
    public void testGetLoader() throws Exception {
        ImageLoaderStrategy loader = ImageLoaderStrategyManager.getInstance().getLoader();
        assertNotNull(loader);
    }

    public void testSetLoader() throws Exception {
        PicassoLoader picassoLoader = new PicassoLoader();
        ImageLoaderStrategyManager instance = ImageLoaderStrategyManager.getInstance();
        instance.setLoader(picassoLoader);
        assertEquals(picassoLoader, instance.getLoader());
    }

    public void testGetInstance() throws Exception {
        ImageLoaderStrategyManager instance = ImageLoaderStrategyManager.getInstance();
        assertNotNull(instance);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testShowImage() throws Exception {

    }

    public void testShowImage1() throws Exception {

    }

}
