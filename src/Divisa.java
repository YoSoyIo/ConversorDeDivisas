public record Divisa(String time_last_update_utc,
                     String time_next_update_utc,
                     float conversion_rate,
                     float conversion_result,
                     String base_code,
                     String target_code) {
}
