package minestrapteam.minestrappolation.spell.variety;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.entity.EntitySpell;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.data.SpellCategory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SpellVarietyAreaShield extends SpellVariety
{
	public SpellVarietyAreaShield(int id, String name)
	{
		super(id, SpellCategory.DEFENSE, name);
	}
	
	@Override
	public void cast(Spell spell, EntityPlayer player, World world)
	{
		if (!world.isRemote)
		{
			SpellAreaShield armor = new SpellAreaShield(world, player);
			armor.setSpell(spell);
			armor.timer = spell.getTotalPotency();
			world.spawnEntityInWorld(armor);
		}
	}
	
	public static class SpellAreaShield extends EntitySpell
	{
		public int	timer	= -1;
		
		public SpellAreaShield(World world)
		{
			super(world);
		}
		
		public SpellAreaShield(World world, EntityLivingBase living)
		{
			super(world, living);
			this.setSize(living.width, living.height);
		}
		
		@Override
		public void setSpellCaster(EntityLivingBase living)
		{
			super.setSpellCaster(living);
			this.setSize(living.width, living.height);
		}
		
		@Override
		public void onEntityUpdate()
		{
			Spell spell = this.getSpell();
			
			if (this.timer == -1 && spell != null)
			{
				this.timer = spell.getTotalPotency();
			}
			else if (this.timer-- == 0)
			{
				this.setDead();
			}
			
			EntityLivingBase living = this.getSpellCaster();
			this.posX = living.posX;
			this.posY = living.posY;
			this.posZ = living.posZ;
			this.rotationYaw = living.rotationYaw;
			
			if (this.worldObj.isRemote && spell != null)
			{
				double y = this.posY + (this.timer % 10 - 10) / 10F * this.height;
				for (int i = 0; i < 8; i++)
				{
					float f = this.rotationYaw + i / 8F * 180F;
					double x = this.posX + MathHelper.sin(f) * this.width;
					double z = this.posZ + MathHelper.cos(f) * this.width;
					
					Minestrappolation.proxy.spawnSpellParticle(spell, x, y, z);
				}
			}
		}
		
		@Override
		public boolean attackEntityFrom(DamageSource source, float damage)
		{
			this.setDead();
			return true;
		}
	}
}
