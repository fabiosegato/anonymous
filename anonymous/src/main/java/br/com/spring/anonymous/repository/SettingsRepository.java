package br.com.spring.anonymous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.spring.anonymous.entity.Settings;


@Repository
public interface SettingsRepository extends JpaRepository<Settings, String> {

	@Modifying
	@Query("delete from Settings t where t.confId = :confId and t.settingName = :key")
	 void deletaSetting(String confId,String key);
	

}

