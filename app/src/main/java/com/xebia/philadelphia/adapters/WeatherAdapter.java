package com.xebia.philadelphia.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xebia.philadelphia.R;
import com.xebia.philadelphia.bean.List;
import com.xebia.philadelphia.bean.WeatherDetails;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class WeatherAdapter extends BaseAdapter {

    private WeatherDetails mWeatherDetails;
    private Context context;
    private int width;
    private LayoutInflater inflater;
    private DisplayImageOptions options;

    public WeatherAdapter(Context context, WeatherDetails mWeatherDetails, int width) {

        this.context = context;
        this.mWeatherDetails = mWeatherDetails;
        this.width = width;
        this.inflater = LayoutInflater.from(context);
        this.options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }

    @Override
    public int getCount() {
        return mWeatherDetails.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return mWeatherDetails.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        View view = convertView;
        if (view == null) {

            holder = new ViewHolder();
            view = inflater.inflate(R.layout.view_weather, parent, false);
            holder.dayImg = (ImageView) view.findViewById(R.id.image);
            holder.dayText = (TextView) view.findViewById(R.id.tvDay);
            holder.minText = (TextView) view.findViewById(R.id.tvMin);
            holder.maxText = (TextView) view.findViewById(R.id.tvMax);
            holder.nightText = (TextView) view.findViewById(R.id.tvNight);
            holder.eveText = (TextView) view.findViewById(R.id.tvEve);
            holder.mornText = (TextView) view.findViewById(R.id.tvMor);
            holder.humidText = (TextView) view.findViewById(R.id.tvHumid);
            holder.descText = (TextView) view.findViewById(R.id.tvDesc);
            holder.dateText = (TextView) view.findViewById(R.id.tvDate);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        List list = mWeatherDetails.getList().get(position);

        holder.dayText.setText(context.getString(R.string.text_day, String.valueOf(list.getTemp().getDay())));
        holder.minText.setText(context.getString(R.string.text_min, String.valueOf(list.getTemp().getMin())));
        holder.maxText.setText(context.getString(R.string.text_max, String.valueOf(list.getTemp().getMax())));
        holder.nightText.setText(context.getString(R.string.text_night, String.valueOf(list.getTemp().getNight())));
        holder.eveText.setText(context.getString(R.string.text_eve, String.valueOf(list.getTemp().getEve())));
        holder.mornText.setText(context.getString(R.string.text_mor, String.valueOf(list.getTemp().getMorn())));

        holder.humidText.setText(context.getString(R.string.text_hum, String.valueOf(list.getHumidity())));
        holder.descText.setText(context.getString(R.string.text_des, String.valueOf(list.getWeather().get(0).getDescription())));

        holder.dateText.setText(getDate(list.getDate()));

        holder.dayImg.getLayoutParams().width = width / 4;
        holder.dayImg.getLayoutParams().height = width / 4;
        ImageLoader.getInstance().displayImage("http://openweathermap.org/img/w/" + list.getWeather().get(0).getIcon() + ".png", holder.dayImg, options);
        return view;
    }

    private String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time * 1000);

        return DateFormat.format("dd-MM-yyyy", cal).toString();
    }

    public class ViewHolder {

        private TextView dateText;
        private TextView dayText;
        private TextView minText;
        private TextView maxText;
        private TextView nightText;
        private TextView eveText;
        private TextView mornText;
        private TextView humidText;
        private TextView descText;
        private ImageView dayImg;


    }


}
