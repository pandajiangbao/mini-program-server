package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Panda;
import com.panda.animeStore.mapper.PandaMapper;
import com.panda.animeStore.service.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2018-12-10 1:33
 */
@Service
public class PandaServiceImpi implements PandaService {
	@Autowired
	private PandaMapper pandaMapper;

	@Override
	public List<Panda> getPandaList() {
		return pandaMapper.selectAll();
	}

	@Override
	public Panda getPandaById(Integer id) {
		return pandaMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public boolean addPanda(Panda panda) {
		if (panda.getTitle() != null && !"".equals(panda.getTitle())) {
			panda.setDate(new Date());
			try {
				int result = pandaMapper.insert(panda);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("插入熊猫信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入熊猫信息失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("熊猫信息不能为空");
		}
	}

	@Override
	public boolean updatePandaById(Panda panda) {
		if (panda.getId() != null && panda.getId() > 0) {
			panda.setDate(new Date());
			try {
				int result = pandaMapper.updateByPrimaryKey(panda);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("更新熊猫信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新熊猫信息失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("熊猫信息不能为空");
		}
	}

	@Override
	public boolean deletePandaById(Integer id) {
		if (id != null) {
			try {
				int result = pandaMapper.deleteByPrimaryKey(id);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("删除熊猫信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除熊猫信息失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("熊猫id不能为空");
		}
	}
}
