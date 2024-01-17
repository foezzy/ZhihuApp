package com.example.zhihuapp.utils;//package com.example.zhihuapp;
//
//import android.content.Context;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.GlideBuilder;
//import com.bumptech.glide.Registry;
//import com.bumptech.glide.annotation.GlideModule;
//import com.bumptech.glide.load.DecodeFormat;
//import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
//import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
//import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
//import com.bumptech.glide.load.engine.cache.LruResourceCache;
//import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
//import com.bumptech.glide.load.model.GlideUrl;
//import com.bumptech.glide.module.AppGlideModule;
//import com.bumptech.glide.request.RequestOptions;
//
//import java.io.File;
//import java.io.InputStream;
//
//import androidx.annotation.NonNull;
//
//@GlideModule
//public class CouponModule extends AppGlideModule {
//    int IMAGE_CACHE_COUNT = 100 * 1024 * 1024;
//
//    @Override
//    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
//        super.registerComponents(context, glide, registry);
////        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
//    }
//
//    @Override
//    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
////        MemorySizeCalculator calculator = new MemorySizeCalculator.Builder(App.Companion.getContext()).build();
////        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
////        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();
////        int defaultArrayPoolSize = calculator.getArrayPoolSizeInBytes();
//        builder.setDefaultRequestOptions(
//                new RequestOptions()
//                        .format(DecodeFormat.PREFER_RGB_565));
////        builder.setMemoryCache(new LruResourceCache(defaultMemoryCacheSize / 2));
////        builder.setBitmapPool(new LruBitmapPool(defaultBitmapPoolSize / 2));
////        builder.setArrayPool(new LruArrayPool(defaultArrayPoolSize / 2));
//
//        builder.setDiskCache(() -> {
//            File cacheLocation = new File(context.getExternalCacheDir(), "GlideCache");
//            if (!cacheLocation.exists()) {
//                boolean result = cacheLocation.mkdirs();
//            } else {
//            }
//            return DiskLruCacheWrapper.create(cacheLocation, 100);
//        });
//    }
//
//}
