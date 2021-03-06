package com.aspsine.mobi.common.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.aspsine.mobi.common.banner.transformer.AccordionTransformer;
import com.aspsine.mobi.common.banner.transformer.BackgroundToForegroundTransformer;
import com.aspsine.mobi.common.banner.transformer.CubeInTransformer;
import com.aspsine.mobi.common.banner.transformer.CubeOutTransformer;
import com.aspsine.mobi.common.banner.transformer.DefaultTransformer;
import com.aspsine.mobi.common.banner.transformer.DepthPageTransformer;
import com.aspsine.mobi.common.banner.transformer.FlipHorizontalTransformer;
import com.aspsine.mobi.common.banner.transformer.FlipVerticalTransformer;
import com.aspsine.mobi.common.banner.transformer.ForegroundToBackgroundTransformer;
import com.aspsine.mobi.common.banner.transformer.RotateDownTransformer;
import com.aspsine.mobi.common.banner.transformer.RotateUpTransformer;
import com.aspsine.mobi.common.banner.transformer.ScaleInOutTransformer;
import com.aspsine.mobi.common.banner.transformer.StackTransformer;
import com.aspsine.mobi.common.banner.transformer.TabletTransformer;
import com.aspsine.mobi.common.banner.transformer.ZoomInTransformer;
import com.aspsine.mobi.common.banner.transformer.ZoomOutSlideTransformer;
import com.aspsine.mobi.common.banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
